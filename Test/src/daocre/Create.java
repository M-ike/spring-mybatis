package daocre;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import daocre.entity.Column;
import daocre.entity.Key;
import daocre.entity.Table;
import daocre.entity.Xml;
import daocre.pdm.PdmParser;



public class Create {
	public static void main(String[] args) {
	}

	public static void createFile(String packPath, String savePath, String pathsql, String namesql, String pdmPath,
			String xmlpath, String sIsPersistence, String projName, String[] tablenames, String dbtype) {
		boolean isOk = true;
		boolean isCreateXml = false;
		boolean isCreateSql = false;
		boolean isPersistence = !"NO".equalsIgnoreCase(sIsPersistence);
		if (projName == null) {
			projName = "komm";
		}
		if ((packPath == null) || (packPath.isEmpty())) {
			isOk = false;
			System.err.println("包路径packpath：不能为空");
		}
		if ((savePath == null) || (savePath.isEmpty())) {
			isOk = false;
			System.err.println("保存文件路径savepath：不能为空");
		}
		if ((pdmPath == null) || (pdmPath.isEmpty())) {
			isOk = false;
			System.err.println("指定PDM文件路径pdmPath：不能为空");
		}
		Xml xml = null;
		if ((xmlpath != null) && (xmlpath.length() > 0)) {
			isCreateXml = true;
			xml = new Xml();
		}
		if ((pathsql != null) && (pathsql.length() > 0)) {
			isCreateSql = true;
		}
		if (isOk) {
			PdmParser pp = new PdmParser();

			List<Table> tabs = new ArrayList();
			if ((tablenames == null) || (tablenames.length <= 0)) {
				Table[] tab = pp.parsePDM_VO(null, pdmPath);
				for (Table t : tab) {
					tabs.add(t);
				}
			} else {
				for (int a = 0; a < tablenames.length; a++) {
					Table[] tab = pp.parsePDM_VO(tablenames[a], pdmPath);
					for (Table t : tab) {
						tabs.add(t);
					}
				}
			}
			for (int i = 0; i < tabs.size(); i++) {
				Table tab = (Table) tabs.get(i);
				try {
					tab.setProjectName(projName);
					tab.writeout(packPath, savePath, tab.getUser().getCode(), isPersistence, dbtype);
					if (isCreateXml) {
						xml.writeout(tab, packPath, xmlpath, dbtype);
					}
				} catch (Exception e) {
					LogUtils.logger.info("=====write error[tablename:" + tab.getTableName() + ",packPath:" + packPath
							+ ",xmlpath:" + savePath + "]======");

					e.printStackTrace();
				}
			}
			if (isCreateSql) {
				List<String> lismsg = generateSQL(tabs, dbtype);
				try {
					CreateFile.writeFile(lismsg, pathsql, namesql);
				} catch (Exception e) {
					LogUtils.logger.info("=====write sql error ======");
					e.printStackTrace();
				}
			}
		}
	}

	private static List<String> generateSQL(List<Table> tabs, String dbtype) {
		List<String> lismsg = new ArrayList();

		if ("oracle".equals(dbtype)) {
			lismsg.add("spool execute.log\n");
			lismsg.add("\n");
		}
		
		for (int i = 0; i < tabs.size(); i++) {
			Table tab = (Table) tabs.get(i);
			Column[] cols = tab.getCols();
			String tabName = "mysql".equals(dbtype)? tab.getTableCode() : tab.getUser().getName() + "." + tab.getTableCode();
			Key pk = tab.getPrimaryKey();

			List<String> createTabNsg = generateTableSQL(tabName, cols, pk, dbtype);
			lismsg.addAll(createTabNsg);
			lismsg.add("\n");
			if ((pk != null) && (pk.getColumnId() != null)) {
				lismsg.add(generatePKSQL(tab, tabName, cols, pk, dbtype));
			}
			lismsg.add("\n");

			lismsg.add(generateTabCommentSQL(tab, tabName, dbtype));
			lismsg.add("\n");

			List<String> commentMsg = generateColCommentSQL(tabName, cols, dbtype);
			lismsg.addAll(commentMsg);
			lismsg.add("\n");
		}
		
		if ("oracle".equals(dbtype)) {
			lismsg.add("spool off\n");
		}

		return lismsg;
	}

	private static Column find(Column[] cols, String code) {
		if (cols == null) {
			return null;
		}
		for (int i = 0; i < cols.length; i++) {
			if (code.equals(cols[i].getCode())) {
				return cols[i];
			}
		}
		return null;
	}

	private static List<String> generateTableSQL(String tabName, Column[] cols, Key pk, String dbtype) {
		List<String> lismsg = new ArrayList();

		Column[] keyCols = null;
		if (pk != null) {
			keyCols = pk.qryColumn(cols);
		}
		lismsg.add("\n");
		
		lismsg.add("-- Create table " + tabName + "\n");
		lismsg.add("-- =================================\n");
		lismsg.add("--\n");
		lismsg.add("create table " + tabName + "\n");
		lismsg.add("(\n");
		for (int j = 0; j < cols.length; j++) {
			StringBuffer columnBuf = new StringBuffer();

			if (("LONG VARCHAR").equalsIgnoreCase(cols[j].getTypefull())
					|| ("TEXT").equalsIgnoreCase(cols[j].getTypefull())) {
				cols[j].setTypefull("CLOB");
				cols[j].setType("CLOB");
			}

			if ("mysql".equals(dbtype)) {
				cols[j].setTypefull(cols[j].getTypefull().replace("NUMBER", "NUMERIC"));
				cols[j].setType(cols[j].getType().replace("NUMBER", "NUMERIC"));
				cols[j].setTypefull(cols[j].getTypefull().replace("CLOB", "BLOB"));
				cols[j].setType(cols[j].getType().replace("CLOB", "BLOB"));
				cols[j].setTypefull(cols[j].getTypefull().replace("DECIMAL", "NUMERIC"));
				cols[j].setType(cols[j].getType().replace("DECIMAL", "NUMERIC"));
				cols[j].setTypefull(cols[j].getTypefull().replace("VARCHAR2", "VARCHAR"));
				cols[j].setType(cols[j].getType().replace("VARCHAR2", "VARCHAR"));
			}
			
			String t = cols[j].getTypefull();
			if ("mysql".equals(dbtype)) {
				if (t.toUpperCase().equals("TIMESTAMP")) {
					t = "datetime";
				}
			}
			columnBuf.append("  ").append(String.format("%-20s", new Object[] { cols[j].getCode() })).append(" ")
					.append(String.format("%-15s", new Object[] { t }));

			Column keyCol = find(keyCols, cols[j].getCode());
			if (keyCol != null) {
				columnBuf.append(" not null");
			}
			if (j < cols.length - 1) {
				columnBuf.append(",");
			}
			columnBuf.append("\n");

			lismsg.add(columnBuf.toString());
		}
		lismsg.add(");\n");

		return lismsg;
	}

	private static String generatePKSQL(Table tab, String tabName, Column[] cols, Key pk, String dbtype) {
		StringBuffer keyBuf = new StringBuffer();
		Column[] keyCols = pk.qryColumn(cols);

		StringBuffer key = new StringBuffer();
		for (int j = 0; j < keyCols.length; j++) {
			key.append(keyCols[j].getCode());
			if (j < keyCols.length - 1) {
				key.append(",");
			}
		}
		keyBuf.append("alter table ").append(tabName).append(" add constraint PK_").append(tab.getTableCode())
				.append(" primary key").append("(" + key + ");\n");
		return keyBuf.toString();
	}

	private static String generateTabCommentSQL(Table tab, String tabName, String dbtype) {
		StringBuffer commentBuf = new StringBuffer();

		String comment = "";
		if ((tab.getComment() != null) && (!tab.getComment().isEmpty())) {
			comment = tab.getComment();
		} else {
			comment = tab.getTableName();
		}
		if ("mysql".equals(dbtype)) {
		} else {
			commentBuf.append("comment on table ").append(tabName).append(" is '").append(comment).append("';\n");
		}
		return commentBuf.toString();
	}

	private static List<String> generateColCommentSQL(String tabName, Column[] cols, String dbtype) {
		List<String> lismsg = new ArrayList();
		for (int j = 0; j < cols.length; j++) {
			StringBuffer colCommentBuf = new StringBuffer();

			String colComment = "";
			if ((cols[j].getComment() != null) && (!cols[j].getComment().isEmpty())) {
				colComment = cols[j].getComment();
			} else {
				colComment = cols[j].getName();
			}
			
			if ("mysql".equals(dbtype)) {
			} else {
				colCommentBuf.append("comment on column ").append(tabName).append(".").append(cols[j].getCode())
					.append(" is '").append(colComment).append("';\n");
			}
			lismsg.add(colCommentBuf.toString());
		}
		return lismsg;
	}

	public static void main1(String[] args) {
		HashMap mp = new HashMap();
		for (int i = 0; i < args.length; i++) {
			int begindex = args[i].indexOf(":");
			if ((begindex >= 0) && (begindex != args[i].length())) {
				mp.put(args[i].substring(0, begindex).toLowerCase(), args[i].substring(begindex + 1));
			}
		}
		System.out.println(mp);
		String packPath = (String) mp.get("packpath");
		String savePath = (String) mp.get("savepath");
		String pdmPath = (String) mp.get("pdm");
		String tablename = (String) mp.get("table");
		String xmlpath = (String) mp.get("xmlpath");
		String sIsPersistence = (String) mp.get("iscreate_persistence");
		String projName = (String) mp.get("projectname");
		String dbtype = "mysql";
		boolean isOk = true;
		boolean isCreateXml = false;
		boolean isPersistence = !"NO".equalsIgnoreCase(sIsPersistence);
		if (projName == null) {
			projName = "komm";
		}
		if ((packPath == null) || (packPath.isEmpty())) {
			isOk = false;
			System.err.println("������packpath����������");
		}
		if ((savePath == null) || (savePath.isEmpty())) {
			isOk = false;
			System.err.println("������������savepath����������");
		}
		if ((pdmPath == null) || (pdmPath.isEmpty())) {
			isOk = false;
			System.err.println("����PDM����pdmPath����������");
		}
		Xml xml = null;
		if ((xmlpath != null) && (xmlpath.length() > 0)) {
			isCreateXml = true;
			xml = new Xml();
		}
		if (isOk) {
			PdmParser pp = new PdmParser();
			Table[] tab = pp.parsePDM_VO(tablename, pdmPath);
			for (int i = 0; i < tab.length; i++) {
				try {
					tab[i].setProjectName(projName);
					tab[i].writeout(packPath, savePath, tab[i].getUser().getCode(), isPersistence, dbtype);
					if (isCreateXml) {
						xml.writeout(tab[i], packPath, xmlpath, dbtype);
					}
				} catch (Exception e) {
					LogUtils.logger.info("=====write error[tablename:" + tablename + ",packPath:" + packPath
							+ ",xmlpath:" + savePath + "]======");

					e.printStackTrace();
				}
			}
		}
	}

	public static void main2() {
		
		String dbtype = "mysql";
		String pathdao = "E:\\workspaces\\P2016041801\\isp_dev\\isp-api\\src\\main\\java\\com\\cmbfae\\isp\\api\\";
		String pathsvn = "E:\\workspaces\\P2016041801\\isp_dev\\isp-api\\src\\main\\resource\\mybatis-config\\mapper\\";

		List<HashMap> lis = new ArrayList();
		HashMap mp1 = new HashMap();
		HashMap mp2 = new HashMap();
		HashMap mp3 = new HashMap();

		mp1.put("PROJECTNAME", "isp.api");
		mp1.put("PACKPATH", "com.cmbfae.isp.api");
		mp1.put("SAVEPATH", pathdao);
		mp1.put("XMLPATH", pathsvn);
		mp1.put("PDMPATH",
				"E:\\workspaces\\P2016041801\\isp_dev\\isp-api\\src\\main\\resource\\mybatis-config\\autocreate.pdm");
		mp1.put("TABLES",
				"MAR_INVITE_CODE;MAR_VOUCHER;MAR_EVENT;MAR_STRATEGY_RANDOM;MAR_RIGHTS_SPEND_SCOPE;MAR_VOUCHER_CONFIG;CIF_DISTRIBUTOR;SPM_EXCHANGE");
		mp1.put("ISCREATE_PERSISTENCE", "YES");
		lis.add(mp1);
		for (HashMap mp : lis) {
			String packPath = (String) mp.get("PACKPATH");
			String savePath = (String) mp.get("SAVEPATH");
			String pdmPath = (String) mp.get("PDMPATH");
			String tablename = (String) mp.get("TABLES");
			String[] tablenames = tablename == null ? null : tablename.split(";");

			String xmlpath = (String) mp.get("XMLPATH");
			String sIsPersistence = (String) mp.get("ISCREATE_PERSISTENCE");
			String projName = (String) mp.get("PROJECTNAME");

			createFile(packPath, savePath, "", "", pdmPath, xmlpath, sIsPersistence, projName, tablenames, dbtype);
		}
	}

	public static void main3(String pathdao, String pathsvn, String pathsql, String namesql, String projectname,
			String pathpack, String pathpdm, String tables, String dbtype) {
		List<HashMap<String, String>> lis = new ArrayList();
		HashMap<String, String> mp1 = new HashMap();

		mp1.put("PROJECTNAME", projectname);
		mp1.put("PACKPATH", pathpack);
		mp1.put("SAVEPATH", pathdao);
		mp1.put("XMLPATH", pathsvn);
		mp1.put("PDMPATH", pathpdm);

		mp1.put("TABLES", tables);
		mp1.put("ISCREATE_PERSISTENCE", "YES");
		lis.add(mp1);
		for (HashMap<String, String> mp : lis) {
			String packPath = (String) mp.get("PACKPATH");
			String savePath = (String) mp.get("SAVEPATH");
			String pdmPath = (String) mp.get("PDMPATH");
			String tablename = (String) mp.get("TABLES");
			String[] tablenames = tablename == null ? null : tablename.split(";");
			String xmlpath = (String) mp.get("XMLPATH");
			String sIsPersistence = (String) mp.get("ISCREATE_PERSISTENCE");
			String projName = (String) mp.get("PROJECTNAME");

			createFile(packPath, savePath, pathsql, namesql, pdmPath, xmlpath, sIsPersistence, projName, tablenames, dbtype);
		}
	}
}
