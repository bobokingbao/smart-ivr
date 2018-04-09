package com.hg.smart.ivr.utils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by litong on 2018/4/7 0007.
 * HttpServletRequest utils
 */

public class RequestUtil {
	/**
	 * output key and value of reuest package
	 * @param request
	 */
	public Map<String, String[]> paramaterToString(HttpServletRequest request) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Map.Entry<String, String[]> e : parameterMap.entrySet()) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
		return parameterMap;
	}

	/**
	 * 获取request中的json字符串
	 * @param request
	 * @return 
	 * @throws IOException 
	 */
	public static String getRequestJsonStr(HttpServletRequest request) throws IOException {
		String method = request.getMethod();
		// GET
		if (method == "GET") {
			String queryString = request.getQueryString();
			queryString = new String(queryString.getBytes("ISO-8859-1"), "UTF-8");
			queryString = queryString.replaceAll("%22", "\"");
			return queryString;
		}
		// POST
		if (method == "POST") {
			String retval = getRequestPostStr(request);
			return retval;
		}

		return null;
	}

	private static String getRequestPostStr(HttpServletRequest request) throws IOException {
		byte[] buf = getRequestPostBytes(request);
		String encoding = request.getCharacterEncoding();
		if (encoding == null) {
			encoding = "UTF-8";
		}
		String retval = new String(buf, encoding);
		return retval;
	}

	private static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
		int contentLen = request.getContentLength();
		byte[] buf = new byte[contentLen];
		for (int i = 0; i < contentLen;) {
			ServletInputStream ins = request.getInputStream();
			int readLen = ins.read(buf, i, contentLen - i);
			if (readLen == -1) {
				break;
			}
			i += readLen;
		}
		return buf;
	}
}
