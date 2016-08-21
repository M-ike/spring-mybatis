package com.business.afi.bean;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import net.javaw.mybatis.generator.Page;


/**
 * 
 * <h1>Title : 产品分配属性 Example Class</h1> 
 *
 * @author		cmbfae.com
 * @version		1.0
 */
public class PralcpropBeanExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public PralcpropBeanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

       public Criteria andAlcprdcodIsNull() {
            addCriterion("ALCPRDCOD is null");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodIsNotNull() {
            addCriterion("ALCPRDCOD is not null");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodEqualTo(String value) {
            addCriterion("ALCPRDCOD =", value, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodNotEqualTo(String value) {
            addCriterion("ALCPRDCOD <>", value, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodGreaterThan(String value) {
            addCriterion("ALCPRDCOD >", value, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodGreaterThanOrEqualTo(String value) {
            addCriterion("ALCPRDCOD >=", value, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodLessThan(String value) {
            addCriterion("ALCPRDCOD <", value, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodLessThanOrEqualTo(String value) {
            addCriterion("ALCPRDCOD <=", value, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodLike(String value) {
            addCriterion("ALCPRDCOD like", value, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodNotLike(String value) {
            addCriterion("ALCPRDCOD not like", value, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodIn(List<String> values) {
            addCriterion("ALCPRDCOD in", values, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodNotIn(List<String> values) {
            addCriterion("ALCPRDCOD not in", values, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodBetween(String value1, String value2) {
            addCriterion("ALCPRDCOD between", value1, value2, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodNotBetween(String value1, String value2) {
            addCriterion("ALCPRDCOD not between", value1, value2, "alcprdcod");
            return (Criteria) this;
        }

        public Criteria andAlcprdcodLikeInsensitive(String value) {
            addCriterion("upper(ALCPRDCOD) like", value.toUpperCase(), "alcprdcod");
            return (Criteria) this;
        }


       public Criteria andAlcprdstsIsNull() {
            addCriterion("ALCPRDSTS is null");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsIsNotNull() {
            addCriterion("ALCPRDSTS is not null");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsEqualTo(String value) {
            addCriterion("ALCPRDSTS =", value, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsNotEqualTo(String value) {
            addCriterion("ALCPRDSTS <>", value, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsGreaterThan(String value) {
            addCriterion("ALCPRDSTS >", value, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsGreaterThanOrEqualTo(String value) {
            addCriterion("ALCPRDSTS >=", value, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsLessThan(String value) {
            addCriterion("ALCPRDSTS <", value, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsLessThanOrEqualTo(String value) {
            addCriterion("ALCPRDSTS <=", value, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsLike(String value) {
            addCriterion("ALCPRDSTS like", value, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsNotLike(String value) {
            addCriterion("ALCPRDSTS not like", value, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsIn(List<String> values) {
            addCriterion("ALCPRDSTS in", values, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsNotIn(List<String> values) {
            addCriterion("ALCPRDSTS not in", values, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsBetween(String value1, String value2) {
            addCriterion("ALCPRDSTS between", value1, value2, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsNotBetween(String value1, String value2) {
            addCriterion("ALCPRDSTS not between", value1, value2, "alcprdsts");
            return (Criteria) this;
        }

        public Criteria andAlcprdstsLikeInsensitive(String value) {
            addCriterion("upper(ALCPRDSTS) like", value.toUpperCase(), "alcprdsts");
            return (Criteria) this;
        }


       public Criteria andAlcorgcodIsNull() {
            addCriterion("ALCORGCOD is null");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodIsNotNull() {
            addCriterion("ALCORGCOD is not null");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodEqualTo(String value) {
            addCriterion("ALCORGCOD =", value, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodNotEqualTo(String value) {
            addCriterion("ALCORGCOD <>", value, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodGreaterThan(String value) {
            addCriterion("ALCORGCOD >", value, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodGreaterThanOrEqualTo(String value) {
            addCriterion("ALCORGCOD >=", value, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodLessThan(String value) {
            addCriterion("ALCORGCOD <", value, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodLessThanOrEqualTo(String value) {
            addCriterion("ALCORGCOD <=", value, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodLike(String value) {
            addCriterion("ALCORGCOD like", value, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodNotLike(String value) {
            addCriterion("ALCORGCOD not like", value, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodIn(List<String> values) {
            addCriterion("ALCORGCOD in", values, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodNotIn(List<String> values) {
            addCriterion("ALCORGCOD not in", values, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodBetween(String value1, String value2) {
            addCriterion("ALCORGCOD between", value1, value2, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodNotBetween(String value1, String value2) {
            addCriterion("ALCORGCOD not between", value1, value2, "alcorgcod");
            return (Criteria) this;
        }

        public Criteria andAlcorgcodLikeInsensitive(String value) {
            addCriterion("upper(ALCORGCOD) like", value.toUpperCase(), "alcorgcod");
            return (Criteria) this;
        }


       public Criteria andAlcntfstsIsNull() {
            addCriterion("ALCNTFSTS is null");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsIsNotNull() {
            addCriterion("ALCNTFSTS is not null");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsEqualTo(String value) {
            addCriterion("ALCNTFSTS =", value, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsNotEqualTo(String value) {
            addCriterion("ALCNTFSTS <>", value, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsGreaterThan(String value) {
            addCriterion("ALCNTFSTS >", value, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsGreaterThanOrEqualTo(String value) {
            addCriterion("ALCNTFSTS >=", value, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsLessThan(String value) {
            addCriterion("ALCNTFSTS <", value, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsLessThanOrEqualTo(String value) {
            addCriterion("ALCNTFSTS <=", value, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsLike(String value) {
            addCriterion("ALCNTFSTS like", value, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsNotLike(String value) {
            addCriterion("ALCNTFSTS not like", value, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsIn(List<String> values) {
            addCriterion("ALCNTFSTS in", values, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsNotIn(List<String> values) {
            addCriterion("ALCNTFSTS not in", values, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsBetween(String value1, String value2) {
            addCriterion("ALCNTFSTS between", value1, value2, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsNotBetween(String value1, String value2) {
            addCriterion("ALCNTFSTS not between", value1, value2, "alcntfsts");
            return (Criteria) this;
        }

        public Criteria andAlcntfstsLikeInsensitive(String value) {
            addCriterion("upper(ALCNTFSTS) like", value.toUpperCase(), "alcntfsts");
            return (Criteria) this;
        }


       public Criteria andAlcntftimIsNull() {
            addCriterion("ALCNTFTIM is null");
            return (Criteria) this;
        }

        public Criteria andAlcntftimIsNotNull() {
            addCriterion("ALCNTFTIM is not null");
            return (Criteria) this;
        }

        public Criteria andAlcntftimEqualTo(Date value) {
            addCriterion("ALCNTFTIM =", value, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimNotEqualTo(Date value) {
            addCriterion("ALCNTFTIM <>", value, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimGreaterThan(Date value) {
            addCriterion("ALCNTFTIM >", value, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimGreaterThanOrEqualTo(Date value) {
            addCriterion("ALCNTFTIM >=", value, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimLessThan(Date value) {
            addCriterion("ALCNTFTIM <", value, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimLessThanOrEqualTo(Date value) {
            addCriterion("ALCNTFTIM <=", value, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimLike(Date value) {
            addCriterion("ALCNTFTIM like", value, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimNotLike(Date value) {
            addCriterion("ALCNTFTIM not like", value, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimIn(List<Date> values) {
            addCriterion("ALCNTFTIM in", values, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimNotIn(List<Date> values) {
            addCriterion("ALCNTFTIM not in", values, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimBetween(Date value1, Date value2) {
            addCriterion("ALCNTFTIM between", value1, value2, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimNotBetween(Date value1, Date value2) {
            addCriterion("ALCNTFTIM not between", value1, value2, "alcntftim");
            return (Criteria) this;
        }

        public Criteria andAlcntftimLikeInsensitive(String value) {
            addCriterion("upper(ALCNTFTIM) like", value.toUpperCase(), "alcntftim");
            return (Criteria) this;
        }


       public Criteria andAlccrtusrIsNull() {
            addCriterion("ALCCRTUSR is null");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrIsNotNull() {
            addCriterion("ALCCRTUSR is not null");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrEqualTo(String value) {
            addCriterion("ALCCRTUSR =", value, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrNotEqualTo(String value) {
            addCriterion("ALCCRTUSR <>", value, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrGreaterThan(String value) {
            addCriterion("ALCCRTUSR >", value, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrGreaterThanOrEqualTo(String value) {
            addCriterion("ALCCRTUSR >=", value, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrLessThan(String value) {
            addCriterion("ALCCRTUSR <", value, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrLessThanOrEqualTo(String value) {
            addCriterion("ALCCRTUSR <=", value, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrLike(String value) {
            addCriterion("ALCCRTUSR like", value, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrNotLike(String value) {
            addCriterion("ALCCRTUSR not like", value, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrIn(List<String> values) {
            addCriterion("ALCCRTUSR in", values, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrNotIn(List<String> values) {
            addCriterion("ALCCRTUSR not in", values, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrBetween(String value1, String value2) {
            addCriterion("ALCCRTUSR between", value1, value2, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrNotBetween(String value1, String value2) {
            addCriterion("ALCCRTUSR not between", value1, value2, "alccrtusr");
            return (Criteria) this;
        }

        public Criteria andAlccrtusrLikeInsensitive(String value) {
            addCriterion("upper(ALCCRTUSR) like", value.toUpperCase(), "alccrtusr");
            return (Criteria) this;
        }


       public Criteria andAlccrttimIsNull() {
            addCriterion("ALCCRTTIM is null");
            return (Criteria) this;
        }

        public Criteria andAlccrttimIsNotNull() {
            addCriterion("ALCCRTTIM is not null");
            return (Criteria) this;
        }

        public Criteria andAlccrttimEqualTo(Date value) {
            addCriterion("ALCCRTTIM =", value, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimNotEqualTo(Date value) {
            addCriterion("ALCCRTTIM <>", value, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimGreaterThan(Date value) {
            addCriterion("ALCCRTTIM >", value, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimGreaterThanOrEqualTo(Date value) {
            addCriterion("ALCCRTTIM >=", value, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimLessThan(Date value) {
            addCriterion("ALCCRTTIM <", value, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimLessThanOrEqualTo(Date value) {
            addCriterion("ALCCRTTIM <=", value, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimLike(Date value) {
            addCriterion("ALCCRTTIM like", value, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimNotLike(Date value) {
            addCriterion("ALCCRTTIM not like", value, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimIn(List<Date> values) {
            addCriterion("ALCCRTTIM in", values, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimNotIn(List<Date> values) {
            addCriterion("ALCCRTTIM not in", values, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimBetween(Date value1, Date value2) {
            addCriterion("ALCCRTTIM between", value1, value2, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimNotBetween(Date value1, Date value2) {
            addCriterion("ALCCRTTIM not between", value1, value2, "alccrttim");
            return (Criteria) this;
        }

        public Criteria andAlccrttimLikeInsensitive(String value) {
            addCriterion("upper(ALCCRTTIM) like", value.toUpperCase(), "alccrttim");
            return (Criteria) this;
        }


       public Criteria andAlcupdusrIsNull() {
            addCriterion("ALCUPDUSR is null");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrIsNotNull() {
            addCriterion("ALCUPDUSR is not null");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrEqualTo(String value) {
            addCriterion("ALCUPDUSR =", value, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrNotEqualTo(String value) {
            addCriterion("ALCUPDUSR <>", value, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrGreaterThan(String value) {
            addCriterion("ALCUPDUSR >", value, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrGreaterThanOrEqualTo(String value) {
            addCriterion("ALCUPDUSR >=", value, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrLessThan(String value) {
            addCriterion("ALCUPDUSR <", value, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrLessThanOrEqualTo(String value) {
            addCriterion("ALCUPDUSR <=", value, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrLike(String value) {
            addCriterion("ALCUPDUSR like", value, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrNotLike(String value) {
            addCriterion("ALCUPDUSR not like", value, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrIn(List<String> values) {
            addCriterion("ALCUPDUSR in", values, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrNotIn(List<String> values) {
            addCriterion("ALCUPDUSR not in", values, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrBetween(String value1, String value2) {
            addCriterion("ALCUPDUSR between", value1, value2, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrNotBetween(String value1, String value2) {
            addCriterion("ALCUPDUSR not between", value1, value2, "alcupdusr");
            return (Criteria) this;
        }

        public Criteria andAlcupdusrLikeInsensitive(String value) {
            addCriterion("upper(ALCUPDUSR) like", value.toUpperCase(), "alcupdusr");
            return (Criteria) this;
        }


       public Criteria andAlcupdtimIsNull() {
            addCriterion("ALCUPDTIM is null");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimIsNotNull() {
            addCriterion("ALCUPDTIM is not null");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimEqualTo(Date value) {
            addCriterion("ALCUPDTIM =", value, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimNotEqualTo(Date value) {
            addCriterion("ALCUPDTIM <>", value, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimGreaterThan(Date value) {
            addCriterion("ALCUPDTIM >", value, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimGreaterThanOrEqualTo(Date value) {
            addCriterion("ALCUPDTIM >=", value, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimLessThan(Date value) {
            addCriterion("ALCUPDTIM <", value, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimLessThanOrEqualTo(Date value) {
            addCriterion("ALCUPDTIM <=", value, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimLike(Date value) {
            addCriterion("ALCUPDTIM like", value, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimNotLike(Date value) {
            addCriterion("ALCUPDTIM not like", value, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimIn(List<Date> values) {
            addCriterion("ALCUPDTIM in", values, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimNotIn(List<Date> values) {
            addCriterion("ALCUPDTIM not in", values, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimBetween(Date value1, Date value2) {
            addCriterion("ALCUPDTIM between", value1, value2, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimNotBetween(Date value1, Date value2) {
            addCriterion("ALCUPDTIM not between", value1, value2, "alcupdtim");
            return (Criteria) this;
        }

        public Criteria andAlcupdtimLikeInsensitive(String value) {
            addCriterion("upper(ALCUPDTIM) like", value.toUpperCase(), "alcupdtim");
            return (Criteria) this;
        }


    }
   public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
   public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}

