package com.hg.smart.ivr.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author litong
 * @date 2018年4月9日23:24:44
 * jackson util
 */
public class JacksonUtil {
	private static final ObjectMapper objMapper = new ObjectMapper();

	/**
	 * pojo ==> json
	 * @param obj
	 * @return
     */
	public static String toJson(Object obj) {
		try {
			return objMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 */
}
