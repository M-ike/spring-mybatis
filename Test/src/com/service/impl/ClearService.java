package com.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.afi.bean.PralcpropBean;
import com.business.afi.dao.PralcpropBeanMapper;
import com.service.IClearService;

import net.javaw.mybatis.generator.Page;

@Service
class ClearService implements IClearService<String, PralcpropBean> {
 
	
/*	@Autowired
	PralcpropBeanMapper pralcpropBeanMapper;
	*/
	@Override
	public String findPage(PralcpropBean params) {
		// TODO Auto-generated method stub
	/*	PralcpropBean res = pralcpropBeanMapper.selectByPrimaryKey(params);
		
		System.out.println(res.getAlcupdusr());*/
		System.out.println("hello");
		return null;
	}

}
