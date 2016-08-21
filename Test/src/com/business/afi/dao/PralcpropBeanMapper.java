package com.business.afi.dao;


import com.business.afi.bean.PralcpropBean;
import com.business.afi.bean.PralcpropBeanExample;
import com.business.afi.bean.PralcpropKey;

import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
 * 
 * <h1>Title : 产品分配属性 Mapper </h1> 
 *
 * @author		cmbfae.com
 * @version		1.0
 */
public interface PralcpropBeanMapper {

    int countByExample(PralcpropBeanExample example);

    int deleteByExample(PralcpropBeanExample example);

    int deleteByPrimaryKey(PralcpropKey key);

    int insert(PralcpropBean record);

    int insertSelective(PralcpropBean record);

    List<PralcpropBean> selectByExample(PralcpropBeanExample example);

    PralcpropBean selectByPrimaryKey(PralcpropKey key);

    List<PralcpropBean> selectByExampleForupdate(PralcpropBeanExample example);

    PralcpropBean selectByPrimaryKeyForupdate(PralcpropKey key);

    int updateByExampleSelective(@Param("record") PralcpropBean record, @Param("example") PralcpropBeanExample example);

    int updateByExample(@Param("record") PralcpropBean record, @Param("example") PralcpropBeanExample example);

    int updateByPrimaryKeySelective(@Param("record") PralcpropBean record);

    int updateByPrimaryKey(@Param("record") PralcpropBean record);
}

