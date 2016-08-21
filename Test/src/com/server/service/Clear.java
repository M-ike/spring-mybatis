package com.server.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.domain.Result;

import net.sf.json.JSONObject;

/**
 * 募集结果通知接口
 * @author chenjl
 *
 */
@Service(value="Clear")
public class Clear implements ServiceApi {
 
	public Result execute(JSONObject params) {

		
		return Result.success();
	}
	
}
