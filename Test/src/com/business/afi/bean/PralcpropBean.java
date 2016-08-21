package com.business.afi.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 
 * <h1>Title : 产品分配属性 Bean</h1> 
 *
 * @author		cmbfae.com
 * @version		1.0
 */
@SuppressWarnings("serial")
public class PralcpropBean extends PralcpropKey {
    private String alcprdsts; //Y/N
    private String alcorgcod; //机构编码
    private String alcntfsts; //A:未通知,S:已通知,F:通知失败
    private Date alcntftim; //通知成功时间
    private String alccrtusr; //产品复核通过后自动插入此条数据
    private Date alccrttim; //创建时间
    private String alcupdusr; //执行分配人
    private Date alcupdtim; //分配时间


    public void init() {
    }
    /**get Y/N*/
    public String getAlcprdsts() {
        return alcprdsts;
    }
    /**set Y/N*/
    public void setAlcprdsts(String alcprdsts) {
        this.alcprdsts = alcprdsts;
    }
    /**get 机构编码*/
    public String getAlcorgcod() {
        return alcorgcod;
    }
    /**set 机构编码*/
    public void setAlcorgcod(String alcorgcod) {
        this.alcorgcod = alcorgcod;
    }
    /**get A:未通知,S:已通知,F:通知失败*/
    public String getAlcntfsts() {
        return alcntfsts;
    }
    /**set A:未通知,S:已通知,F:通知失败*/
    public void setAlcntfsts(String alcntfsts) {
        this.alcntfsts = alcntfsts;
    }
    /**get 通知成功时间*/
    public Date getAlcntftim() {
        return alcntftim;
    }
    /**set 通知成功时间*/
    public void setAlcntftim(Date alcntftim) {
        this.alcntftim = alcntftim;
    }
    /**get 产品复核通过后自动插入此条数据*/
    public String getAlccrtusr() {
        return alccrtusr;
    }
    /**set 产品复核通过后自动插入此条数据*/
    public void setAlccrtusr(String alccrtusr) {
        this.alccrtusr = alccrtusr;
    }
    /**get 创建时间*/
    public Date getAlccrttim() {
        return alccrttim;
    }
    /**set 创建时间*/
    public void setAlccrttim(Date alccrttim) {
        this.alccrttim = alccrttim;
    }
    /**get 执行分配人*/
    public String getAlcupdusr() {
        return alcupdusr;
    }
    /**set 执行分配人*/
    public void setAlcupdusr(String alcupdusr) {
        this.alcupdusr = alcupdusr;
    }
    /**get 分配时间*/
    public Date getAlcupdtim() {
        return alcupdtim;
    }
    /**set 分配时间*/
    public void setAlcupdtim(Date alcupdtim) {
        this.alcupdtim = alcupdtim;
    }


    /** set **/
    public void setEntity(PralcpropBean orgEntity) {
        if (orgEntity == null) return ; 
        if(orgEntity.alcprdcod!=null) alcprdcod = orgEntity.alcprdcod;
        if(orgEntity.alcprdsts!=null) alcprdsts = orgEntity.alcprdsts;
        if(orgEntity.alcorgcod!=null) alcorgcod = orgEntity.alcorgcod;
        if(orgEntity.alcntfsts!=null) alcntfsts = orgEntity.alcntfsts;
        if(orgEntity.alcntftim!=null) alcntftim = orgEntity.alcntftim;
        if(orgEntity.alccrtusr!=null) alccrtusr = orgEntity.alccrtusr;
        if(orgEntity.alccrttim!=null) alccrttim = orgEntity.alccrttim;
        if(orgEntity.alcupdusr!=null) alcupdusr = orgEntity.alcupdusr;
        if(orgEntity.alcupdtim!=null) alcupdtim = orgEntity.alcupdtim;
    }
}
