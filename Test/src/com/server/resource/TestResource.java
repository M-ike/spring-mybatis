package com.server.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.server.domain.Result;

import net.sf.json.JSONObject;


@Path("")
public class TestResource {
	
	private static Logger logger = Logger.getLogger(TestResource.class);
	
	@Autowired
	private ApiDispatch dispatch;
	
	@POST
    @Produces({MediaType.APPLICATION_JSON})
    public Result dispatch(String data)
    {
		logger.debug("#receive msg from rest server:\n" + data );		
		JSONObject json = null;
		try {
			json=JSONObject.fromObject(data);
		} catch (Exception e) {
			logger.debug("error json");
			return Result.error();
		}
		
	
		String serviceName = json.getString("SERVICENAME");
		JSONObject busiData = json.getJSONObject("BUSIDATA");
		
		return dispatch.doit(serviceName, busiData);
		
    }
	@GET
    @Produces({MediaType.TEXT_PLAIN})
    public String dispatch1(String data)
    {
		logger.debug("get msg:" + data);
		System.out.println("get msg:" + data);
		return "<ns0:RespParam xmlns:ns0=\"http://BTS_msg_transfer.Schema2\"><RetCode>RetCode_0</RetCode><ErrMsg>ErrMsg_0</ErrMsg><Data>Data_0</Data></ns0:RespParam>";
    }
}
