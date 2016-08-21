package daocre.entity;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import daocre.CreateFile;

public class Xml
{
  public static String underlineToCamel(String param)
  {
    if ((param == null) || ("".equals(param.trim()))) {
      return "";
    }
    int len = param.length();
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++)
    {
      char c = param.charAt(i);
      if (c == '_')
      {
        i++;
        if (i < len) {
          sb.append(Character.toUpperCase(param.charAt(i)));
        }
      }
      else
      {
        sb.append(c);
      }
    }
    return sb.toString();
  }
  
  public void writeout(Table table, String packPath, String xmlPath, String dbtype)
    throws Exception
  {
    List lismsg = xmlMode(table, table.getDbUser(), packPath  + "." + table.getUser().getName(), dbtype);
    String name = table.getTableCode().toLowerCase() + "-mapper.xml";
    CreateFile.writeFile(lismsg, xmlPath + File.separator +table.getUser().getName() + File.separator, name);
  }
  
  public List<String> xmlMode(Table table, String dbuser, String packPath, String dbtype)
    throws Exception
  {
    String LINECHAR = "\r\n";
    String resultMapField = "";
    String insfield = "";
    String insvalue = "";
    String getfield = "";
    String getkey = "";
    String getkeyWithRecord = "";
    String getwhere = "";
    String updset1 = "";
    String updset2 = "";
    String insertSelectiveField = "";
    String insertSelectiveValue = "";
    String updateField = "";
    String updateValue = "";
    String username = table.getIbatisUser();
    
    List msg = new ArrayList();
    if ((table.getCols() == null) || (table.getCols().length <= 0)) {
      return msg;
    }
    Column[] cols = table.getCols();
    Column[] keycs = (Column[])null;
    Key key = table.getPrimaryKey();
    if (key != null) {
      keycs = table.getPrimaryKey().qryColumn(cols);
    }
    for (int i = 0; i < cols.length; i++)
    {
      resultMapField = 
      
        resultMapField + "      <result column=\"" + cols[i].getCode().toUpperCase() + "\" property=\"" + underlineToCamel(cols[i].getCode().toLowerCase()) + "\" />";
      insfield = insfield + cols[i].getCode().toUpperCase();
      String p = cols[i].getSPrecision();
      Integer l = cols[i].getLength();
      insvalue = insvalue + "#{" + underlineToCamel(cols[i].getCode()) + ", jdbcType=" + fitType(cols[i].getType(), l == null ? 0 : l.intValue(), p) + 
        "}";
      getfield = getfield + LINECHAR + "                  " + 
        cols[i].getCode() + " \"" + 
        cols[i].getCode().toLowerCase() + "\"";
  
      boolean flag = false;
      if (keycs != null) {
        for (int j = 0; j < keycs.length; j++) {
          if (keycs[j].getCode().equalsIgnoreCase(cols[i].getCode()))
          {
            flag = true;
            break;
          }
        }
      }
      {
        getwhere = 
        
          getwhere + LINECHAR + "        <isNotEmpty prepend=\" and \" property=\"" + cols[i].getCode() + "\"><![CDATA[" + cols[i].getCode() + "=#" + cols[i].getCode() + "#]]></isNotEmpty>";
        if (!flag) {
          updset2 = 
          
            updset2 + LINECHAR + "        <isNotEmpty prepend=\" , \" property=\"" + cols[i].getCode() + "\"><![CDATA[" + cols[i].getCode() + "=#" + cols[i].getCode() + "#]]></isNotEmpty>";
        }
      }
      {
        insertSelectiveField = 
        
          insertSelectiveField + "      <if test=\"" + underlineToCamel(cols[i].getCode()) + " != null\">" + cols[i].getCode().toUpperCase() + ",</if>" + LINECHAR;
      }
      {
        insertSelectiveValue = 
        
          insertSelectiveValue + "      <if test=\"" + underlineToCamel(cols[i].getCode()) + " != null\">#{" + underlineToCamel(cols[i].getCode()) + ", jdbcType=" + fitType(cols[i].getType(), l == null ? 0 : l.intValue(), p) + "},</if>" + LINECHAR;
      }
     {
        updateField = 
        
          updateField + "      <if test=\"record." + underlineToCamel(cols[i].getCode()) + " != null\">" + cols[i].getCode().toUpperCase() + " = #{record." + underlineToCamel(cols[i].getCode()) + ", jdbcType=" + fitType(cols[i].getType(), l == null ? 0 : l.intValue(), p) + "}, </if>" + LINECHAR;
      }
      {
        updateValue = 
        
          updateValue + "      " + cols[i].getCode().toUpperCase() + " = #{record." + underlineToCamel(cols[i].getCode()) + ", jdbcType=" + fitType(cols[i].getType(), l == null ? 0 : l.intValue(), p) + "}";
      }
      if (i < cols.length - 1)
      {
        insfield = insfield + ", ";
        insvalue = insvalue + ", ";
        getfield = getfield + ", ";
        if (updateValue.trim().charAt(updateValue.trim().length() - 1) != ',') {
        	updateValue = updateValue + ",";
        }
        resultMapField = resultMapField + LINECHAR;
      }
      updateValue = updateValue + LINECHAR;
    }
    if (keycs != null) {
      for (int i = 0; i < keycs.length; i++)
      {
        if (i > 0)
        {
          getkey = getkey + LINECHAR + "                  and ";
          getkeyWithRecord = getkeyWithRecord + LINECHAR + "                  and ";
        }
        String p = keycs[i].getSPrecision();
        Integer l = keycs[i].getLength();
        
        getkey = getkey + keycs[i].getCode() + " = #{" + 
          underlineToCamel(keycs[i].getCode()) + ", jdbcType=" + fitType(keycs[i].getType(), l == null ? 0 : l.intValue(), p) + "} ";
        
        getkeyWithRecord = getkeyWithRecord + keycs[i].getCode() + " = #{record." + 
          underlineToCamel(keycs[i].getCode()) + ", jdbcType=" + fitType(keycs[i].getType(), l == null ? 0 : l.intValue(), p) + "} ";
        
      }
    }
    msg.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + LINECHAR);
    msg.add("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">" + 
      LINECHAR);
    msg.add("<mapper namespace=\"" + packPath + ".dao." + 
      table.getTableClassName() + "Mapper\">" + LINECHAR + LINECHAR);
    
    msg.add("  <resultMap id=\"BaseResultMap\" type=\"" + packPath + 
      ".bean." + table.getTableClassName() + "\">" + LINECHAR);
    msg.add(resultMapField + LINECHAR);
    msg.add("  </resultMap>");
    
    msg.add(LINECHAR + LINECHAR);
    
    msg.add("  <sql id=\"Example_Where_Clause\">" + LINECHAR);
    msg.add("    <where>" + LINECHAR);
    msg.add("      <foreach collection=\"oredCriteria\" item=\"criteria\" separator=\"or\">" + 
      LINECHAR);
    msg.add("        <if test=\"criteria.valid\">" + LINECHAR);
    msg.add("          <trim prefix=\"(\" prefixOverrides=\"and\" suffix=\")\">" + 
      LINECHAR);
    msg.add("            <foreach collection=\"criteria.criteria\" item=\"criterion\">" + 
      LINECHAR);
    msg.add("              <choose>" + LINECHAR);
    msg.add("                <when test=\"criterion.noValue\">" + LINECHAR);
    msg.add("                  and ${criterion.condition}" + LINECHAR);
    msg.add("                </when>" + LINECHAR);
    msg.add("                <when test=\"criterion.singleValue\">" + 
      LINECHAR);
    msg.add("                  and ${criterion.condition} #{criterion.value}" + 
      LINECHAR);
    msg.add("                </when>" + LINECHAR);
    msg.add("                <when test=\"criterion.betweenValue\">" + 
      LINECHAR);
    msg.add("                  and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}" + 
      LINECHAR);
    msg.add("                </when>" + LINECHAR);
    msg.add("                <when test=\"criterion.listValue\">" + 
      LINECHAR);
    msg.add("                  and ${criterion.condition}" + LINECHAR);
    msg.add("                  <foreach close=\")\" collection=\"criterion.value\" item=\"listItem\" open=\"(\" separator=\",\">" + 
      LINECHAR);
    msg.add("                    #{listItem}" + LINECHAR);
    msg.add("                  </foreach>" + LINECHAR);
    msg.add("                </when>" + LINECHAR);
    msg.add("              </choose>" + LINECHAR);
    msg.add("            </foreach>" + LINECHAR);
    msg.add("          </trim>" + LINECHAR);
    msg.add("        </if>" + LINECHAR);
    msg.add("      </foreach>" + LINECHAR);
    msg.add("    </where>" + LINECHAR);
    msg.add("  </sql>" + LINECHAR);
    msg.add(LINECHAR);
    msg.add("  <sql id=\"Update_By_Example_Where_Clause\">" + LINECHAR);
    msg.add("    <where>" + LINECHAR);
    msg.add("      <foreach collection=\"example.oredCriteria\" item=\"criteria\" separator=\"or\">" + 
      LINECHAR);
    msg.add("        <if test=\"criteria.valid\">" + LINECHAR);
    msg.add("          <trim prefix=\"(\" prefixOverrides=\"and\" suffix=\")\">" + 
      LINECHAR);
    msg.add("            <foreach collection=\"criteria.criteria\" item=\"criterion\">" + 
      LINECHAR);
    msg.add("              <choose>" + LINECHAR);
    msg.add("                <when test=\"criterion.noValue\">" + LINECHAR);
    msg.add("                  and ${criterion.condition}" + LINECHAR);
    msg.add("                </when>" + LINECHAR);
    msg.add("                <when test=\"criterion.singleValue\">" + 
      LINECHAR);
    msg.add("                  and ${criterion.condition} #{criterion.value}" + 
      LINECHAR);
    msg.add("                </when>" + LINECHAR);
    msg.add("                <when test=\"criterion.betweenValue\">" + 
      LINECHAR);
    msg.add("                  and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}" + 
      LINECHAR);
    msg.add("                </when>" + LINECHAR);
    msg.add("                <when test=\"criterion.listValue\">" + 
      LINECHAR);
    msg.add("                  and ${criterion.condition}" + LINECHAR);
    msg.add("                  <foreach close=\")\" collection=\"criterion.value\" item=\"listItem\" open=\"(\" separator=\",\">" + 
      LINECHAR);
    msg.add("                    #{listItem}" + LINECHAR);
    msg.add("                  </foreach>" + LINECHAR);
    msg.add("                </when>" + LINECHAR);
    msg.add("              </choose>" + LINECHAR);
    msg.add("            </foreach>" + LINECHAR);
    msg.add("          </trim>" + LINECHAR);
    msg.add("        </if>" + LINECHAR);
    msg.add("      </foreach>" + LINECHAR);
    msg.add("    </where>" + LINECHAR);
    msg.add("  </sql>" + LINECHAR);
    
    msg.add(LINECHAR);
    
    msg.add("  <sql id=\"Base_Column_List\">" + LINECHAR);
    msg.add("    " + insfield + LINECHAR);
    msg.add("  </sql>" + LINECHAR);
    
    msg.add(LINECHAR);
    
    msg.add("  <select id=\"selectByExample\" parameterType=\"" + packPath + 
      ".bean." + table.getTableClassName() + 
      "Example\" resultMap=\"BaseResultMap\">" + LINECHAR);
    if ("oracle".equals(dbtype)) {
    	msg.add("    <include refid=\"OracleDialectPrefix\" />" + LINECHAR);
    } else if ("mysql".equals(dbtype)) {
    	msg.add("    <include refid=\"MysqlDialectPrefix\" />" + LINECHAR);
    }
    msg.add("    select" + LINECHAR);
    msg.add("    <if test=\"distinct\">" + LINECHAR);
    msg.add("      distinct" + LINECHAR);
    msg.add("    </if>" + LINECHAR);
    msg.add("    <include refid=\"Base_Column_List\" />" + LINECHAR);
    msg.add("    from " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
    msg.add("    <if test=\"_parameter != null\">" + LINECHAR);
    msg.add("      <include refid=\"Example_Where_Clause\" />" + LINECHAR);
    msg.add("    </if>" + LINECHAR);
    msg.add("    <if test=\"orderByClause != null\">" + LINECHAR);
    msg.add("      order by ${orderByClause}" + LINECHAR);
    msg.add("    </if>" + LINECHAR);
    if ("oracle".equals(dbtype)) {
    	msg.add("    <include refid=\"OracleDialectSuffix\" />" + LINECHAR);
    } else if ("mysql".equals(dbtype)) {
    	msg.add("    <include refid=\"MysqlDialectSuffix\" />" + LINECHAR);
    }
    msg.add("  </select>" + LINECHAR);
    
    msg.add(LINECHAR);
    
    msg.add("  <select id=\"selectByExampleForupdate\" parameterType=\"" + packPath + 
      ".bean." + table.getTableClassName() + 
      "Example\" resultMap=\"BaseResultMap\">" + LINECHAR);
    if ("oracle".equals(dbtype)) {
    	msg.add("    <include refid=\"OracleDialectPrefix\" />"+ LINECHAR);
    } else if ("mysql".equals(dbtype)) {
    	msg.add("    <include refid=\"MysqlDialectPrefix\" />"+ LINECHAR);
    }
    msg.add("    select" + LINECHAR);
    msg.add("    <if test=\"distinct\">" + LINECHAR);
    msg.add("      distinct" + LINECHAR);
    msg.add("    </if>" + LINECHAR);
    msg.add("    <include refid=\"Base_Column_List\" />" + LINECHAR);
    msg.add("    from " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
    msg.add("    <if test=\"_parameter != null\">" + LINECHAR);
    msg.add("      <include refid=\"Example_Where_Clause\" />" + LINECHAR);
    msg.add("    </if>" + LINECHAR);
    msg.add("    <if test=\"orderByClause != null\">" + LINECHAR);
    msg.add("      order by ${orderByClause}" + LINECHAR);
    msg.add("    </if>" + LINECHAR);
    if ("oracle".equals(dbtype)) {
    	msg.add("    <include refid=\"OracleDialectSuffix\" />" + LINECHAR);
    } else if ("mysql".equals(dbtype)) {
    	msg.add("    <include refid=\"MysqlDialectSuffix\" />" + LINECHAR);
    }
    msg.add("    for update" + LINECHAR);
    msg.add("  </select>" + LINECHAR);
    
    msg.add(LINECHAR);
    if ((keycs != null) && (keycs.length > 0))
    {
      msg.add("  <select id=\"selectByPrimaryKey\" parameterType=\"" + packPath + 
        ".bean." + table.getKeyClassName() + "\" resultMap=\"BaseResultMap\">" + LINECHAR);
      msg.add("    select " + LINECHAR);
      msg.add("    <include refid=\"Base_Column_List\" />" + LINECHAR);
      msg.add("    from " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
      msg.add("    where " + getkey + LINECHAR);
      msg.add("  </select>" + LINECHAR);
      
      msg.add(LINECHAR);
      
      msg.add("  <select id=\"selectByPrimaryKeyForupdate\" parameterType=\"" + packPath + 
        ".bean." + table.getKeyClassName() + "\" resultMap=\"BaseResultMap\">" + LINECHAR);
      msg.add("    select " + LINECHAR);
      msg.add("    <include refid=\"Base_Column_List\" />" + LINECHAR);
      msg.add("    from " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
      msg.add("    where " + getkey + LINECHAR);
      msg.add("    for update");
      msg.add("  </select>" + LINECHAR);
      
      msg.add(LINECHAR);
      
      msg.add("  <delete id=\"deleteByPrimaryKey\" parameterType=\"" + packPath + 
        ".bean." + table.getKeyClassName() + "\">" + LINECHAR);
      msg.add("    delete from " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
      msg.add("    where " + getkey + LINECHAR);
      msg.add("  </delete>" + LINECHAR);
      
      msg.add(LINECHAR);
    }
    msg.add("  <delete id=\"deleteByExample\" parameterType=\"" + packPath + 
      ".bean." + table.getTableClassName() + "Example\">" + 
      LINECHAR);
    msg.add("    delete from " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
    msg.add("    <if test=\"_parameter != null\">" + LINECHAR);
    msg.add("      <include refid=\"Example_Where_Clause\" />" + LINECHAR);
    msg.add("    </if>" + LINECHAR);
    msg.add("  </delete>" + LINECHAR);
    
    msg.add(LINECHAR);
    
    msg.add("  <insert id=\"insert\" parameterType=\"" + packPath + 
      ".bean." + table.getTableClassName() + "\">" + LINECHAR);
    msg.add("    insert into " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + " (" + 
      insfield + ")" + LINECHAR);
    msg.add("    values (" + insvalue + ")" + LINECHAR);
    msg.add("  </insert>" + LINECHAR);
    
    msg.add(LINECHAR);
    
    msg.add("  <insert id=\"insertSelective\" parameterType=\"" + packPath + 
      ".bean." + table.getTableClassName() + "\">" + LINECHAR);
    msg.add("    insert into " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
    msg.add("    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">" + 
      LINECHAR);
    msg.add(insertSelectiveField);
    msg.add("    </trim>" + LINECHAR);
    msg.add("    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">" + 
      LINECHAR);
    msg.add(insertSelectiveValue);
    msg.add("    </trim>" + LINECHAR);
    msg.add("  </insert>" + LINECHAR);
    
    msg.add(LINECHAR);
    
    msg.add("  <select id=\"countByExample\" parameterType=\"" + packPath + 
      ".bean." + table.getTableClassName() + 
      "Example\" resultType=\"java.lang.Integer\">" + LINECHAR);
    msg.add("    select count(*) from " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + 
      LINECHAR);
    msg.add("    <if test=\"_parameter != null\">" + LINECHAR);
    msg.add("      <include refid=\"Example_Where_Clause\" />" + LINECHAR);
    msg.add("    </if>" + LINECHAR);
    msg.add("  </select>" + LINECHAR);
    
    msg.add(LINECHAR);
    
    msg.add("  <update id=\"updateByExampleSelective\" parameterType=\"map\">" + LINECHAR);
    msg.add("    update " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
    msg.add("    <set>" + LINECHAR);
    msg.add(updateField);
    msg.add("    </set>" + LINECHAR);
    msg.add("    <if test=\"_parameter != null\">" + LINECHAR);
    msg.add("      <include refid=\"Update_By_Example_Where_Clause\" />" + 
      LINECHAR);
    msg.add("    </if>" + LINECHAR);
    msg.add("  </update>" + LINECHAR);
    
    msg.add(LINECHAR);
    
    msg.add("  <update id=\"updateByExample\" parameterType=\"map\">" + 
      LINECHAR);
    msg.add("    update " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
    msg.add("    set " + LINECHAR);
    msg.add(updateValue);
    msg.add("    <if test=\"_parameter != null\">" + LINECHAR);
    msg.add("      <include refid=\"Update_By_Example_Where_Clause\" />" + 
      LINECHAR);
    msg.add("    </if>" + LINECHAR);
    msg.add("  </update>" + LINECHAR);
    
    msg.add(LINECHAR);
    if ((keycs != null) && (keycs.length > 0))
    {
      msg.add("  <update id=\"updateByPrimaryKeySelective\" parameterType=\"map\">" + 
        LINECHAR);
      msg.add("    update " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
      msg.add("    <set>" + LINECHAR);
      msg.add(updateField);
      msg.add("    </set>" + LINECHAR);
      msg.add("    where " + getkeyWithRecord + LINECHAR);
      msg.add("  </update>" + LINECHAR);
      
      msg.add(LINECHAR);
      
      msg.add("  <update id=\"updateByPrimaryKey\" parameterType=\"map\">" + 
        LINECHAR);
      msg.add("    update " + ("mysql".equals(dbtype)? "" : dbuser) + table.getTableCode() + LINECHAR);
      msg.add("    set " + LINECHAR);
      msg.add(updateValue);
      msg.add("    where " + getkeyWithRecord + LINECHAR);
      msg.add("  </update>" + LINECHAR);
      
      msg.add(LINECHAR);
    }
    if ("oracle".equals(dbtype)) {
	    msg.add("  <sql id=\"OracleDialectPrefix\" >" + LINECHAR);
	    msg.add("    <if test=\"page != null\" >" + LINECHAR);
	    msg.add("      select * from ( select row_.*, rownum rownum_ from ( " + 
	      LINECHAR);
	    msg.add("    </if>" + LINECHAR);
	    msg.add("  </sql>" + LINECHAR);
	    msg.add("  <sql id=\"OracleDialectSuffix\" >" + LINECHAR);
	    msg.add("    <if test=\"page != null\" >" + LINECHAR);
	    msg.add("      <![CDATA[ ) row_ ) where rownum_ > #{page.begin} and rownum_ <= #{page.end} ]]>" + 
	      LINECHAR);
	    msg.add("    </if>" + LINECHAR);
	    msg.add("  </sql>" + LINECHAR);
    } else if ("mysql".equals(dbtype)) {
	    msg.add("  <sql id=\"MysqlDialectPrefix\" >" + LINECHAR);
	    msg.add("    <if test=\"page != null\" >" + LINECHAR);
	    msg.add("    </if>" + LINECHAR);
	    msg.add("  </sql>" + LINECHAR);
	    msg.add("  <sql id=\"MysqlDialectSuffix\" >" + LINECHAR);
	    msg.add("    <if test=\"page != null\" >" + LINECHAR);
	    msg.add("      <![CDATA[ limit #{page.begin} , #{page.length} ]]>" +  LINECHAR);
	    msg.add("    </if>" + LINECHAR);
	    msg.add("  </sql>" + LINECHAR);
    	
    }
    msg.add(LINECHAR + LINECHAR + "</mapper>");
    
    return msg;
  }
  
  private String fitType(String type, int length, String percision)
  {
    String typeRight = "VARCHAR";
    if (type.equalsIgnoreCase("NUMBER") || type.equalsIgnoreCase("DECIMAL"))
    {
      if ((percision != null) && (Integer.valueOf(percision).intValue() > 0))
      {
        if (length >= 12) {
          typeRight = "DECIMAL";
        } else {
          typeRight = "Double";
        }
      }
      else if (length >= 9) {
        typeRight = "BIGINT";
      } else {
        typeRight = "Integer";
      }
    }
    else if (type.equalsIgnoreCase("DATE")) {
      typeRight = "Date";
    } else if (type.equalsIgnoreCase("TIMESTAMP")) {
      typeRight = "TIMESTAMP";
    } else if (type.equalsIgnoreCase("INTEGER")) {
      typeRight = "Integer";
    }else if (type.equalsIgnoreCase("LONG VARCHAR") || type.equalsIgnoreCase("TEXT")) {
        typeRight = "CLOB";
    }
    else if (type.equalsIgnoreCase("CLOB")) {
        typeRight = "CLOB";
    }else if (type.equalsIgnoreCase("CHAR")) {
        typeRight = "CHAR";
    } else {
      typeRight = "VARCHAR";
    }
    return typeRight.toUpperCase();
  }
}
