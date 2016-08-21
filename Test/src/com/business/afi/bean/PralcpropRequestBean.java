package com.business.afi.bean;


/**
 * 
 * <h1>Title : 产品分配属性 RequestBean</h1> 
 *
 * @author		cmbfae.com
 * @version		1.0
 */
@SuppressWarnings("serial")
public class PralcpropRequestBean extends PralcpropBean {
    private int page;
    private int pageCount;


    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page  = page;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount  = pageCount;
    }


}
