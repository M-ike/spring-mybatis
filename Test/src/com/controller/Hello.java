package com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.afi.bean.PralcpropBean;
import com.business.afi.bean.PralcpropKey;
import com.business.afi.dao.PralcpropBeanMapper;
import com.service.IClearService;



@Controller
@RequestMapping("mvc")
public class Hello {
	

	/*private IClearService<String, PralcpropBean> clearService;*/
	@Autowired
	private PralcpropBeanMapper pralcpropBeanMapper;
	
	@RequestMapping("/hello")
	public String hello(){
		PralcpropBean pralcpropBean = new PralcpropBean();
		pralcpropBean.setAlcprdcod("0001");

		pralcpropBean.setAlccrttim(new Date());
		pralcpropBean.setAlccrtusr("zql");
		pralcpropBean.setAlcntfsts("Y");
		pralcpropBean.setAlcntftim(new Date());
		pralcpropBean.setAlcorgcod("0001");
		pralcpropBean.setAlcprdsts("s");
		pralcpropBean.setAlcupdtim(new Date());
		pralcpropBean.setAlcupdusr("zql");
		
		/*PralcpropKey pralcpropKey = new PralcpropKey();
		pralcpropKey.setKey("0001");*/
		PralcpropBean res = pralcpropBeanMapper.selectByPrimaryKey(pralcpropBean);
		
		System.out.println(res);
		
	    return "hello";
	}
}
