package daocre.util;



import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import daocre.Create;
import daocre.LogUtils;


public class CodeAutoCreater extends AbstractMojo {

	private String pathdao = "src/com/business/";
	private String pathsvn = "src/com/business/mapper/";
	private String pathpack = "com.business";
	private String projectname = "business";
	private String pathpdm = "src/resource/平台业务表结构.pdm";
//	private String tables = "PRALCPROP;PRDSCINFP;TRPAYINFP;TRRASINFP;BASDATCTY;BASDATPRV;DIDEFINFP;DIITMDTLP;LGOPRINFP;TRPAYCFMP;OGCLTMNGP";
	private String tables = "PRALCPROP";
	private String pathsql = "src/resource/sql/";
	private String namesql = "fae-BUSINESS.sql";
	private String dbtype = "mysql"; // mysql or oracle
	private File basedir = null;

	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("根据pdm生成代码");
		String rootPath = System.getProperty("user.dir");
		
		basedir =  new File(rootPath);
		String baseDirStr = "";
		try {
			baseDirStr = this.basedir.getCanonicalPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtils.logger = getLog();
		this.pathdao = (baseDirStr + File.separator + this.pathdao);
		this.pathsvn = (baseDirStr + File.separator + this.pathsvn);
		this.pathpdm = (baseDirStr + File.separator + this.pathpdm);
		this.pathsql = (baseDirStr + File.separator + this.pathsql);

		getLog().info("pathdao = " + this.pathdao);
		getLog().info("pathsvn = " + this.pathsvn);
		getLog().info("pathpdm = " + this.pathpdm);
		getLog().info("pathsql = " + this.pathsql);

		Create.main3(this.pathdao, this.pathsvn, this.pathsql, this.namesql, this.projectname, this.pathpack,
				this.pathpdm, this.tables, this.dbtype);
	}

	public static void main(String[] args) {
	
		CodeAutoCreater cac = new CodeAutoCreater();
		try {
			cac.execute();
		} catch (MojoExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MojoFailureException e) {
			e.printStackTrace();
		}
	}

}
