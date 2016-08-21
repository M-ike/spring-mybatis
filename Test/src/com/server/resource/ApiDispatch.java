package com.server.resource;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.domain.Result;
import com.server.service.ServiceApi;

import net.sf.json.JSONObject;

@Service
public class ApiDispatch {

	private static Logger logger = Logger.getLogger(ApiDispatch.class);  
	
	@Autowired
	private Map<String, ServiceApi> serviceApis;
	
	public Result doit(String serviceName, JSONObject busiData) {
		ServiceApi api = serviceApis.get(serviceName);
		
		return api.execute(busiData);
	
	}
}
