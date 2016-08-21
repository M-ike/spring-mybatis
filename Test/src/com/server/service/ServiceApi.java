package com.server.service;



import com.server.domain.Result;

import net.sf.json.JSONObject;

/**
 * api类入�?
 * @author chenjl
 *
 */
public interface ServiceApi {

	public Result execute(JSONObject params);
	
}
