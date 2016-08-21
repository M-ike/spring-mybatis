package com.business.afi.bean;


import java.math.BigDecimal;

/**
 * 
 * <h1>Title : 产品分配属性 Key</h1> 
 *
 * @author		cmbfae.com
 * @version		1.0
 */
@SuppressWarnings("serial")
public class PralcpropKey {

    protected String alcprdcod; //产品编码


    public void setKey(String alcprdcod) {
        this.alcprdcod=alcprdcod;
    }
    /**get 产品编码*/
    public String getAlcprdcod() {
        return alcprdcod;
    }
    /**set 产品编码*/
    public void setAlcprdcod(String alcprdcod) {
        this.alcprdcod = alcprdcod;
    }
}
