package com.hg.smart.ivr.controller;

import com.hg.smart.ivr.model.FirstSession;
import com.hg.smart.ivr.utils.HTTPClient;
import com.hg.smart.ivr.utils.JacksonUtil;
import org.apache.http.entity.StringEntity;
import org.junit.Test;
import org.springframework.http.MediaType;

/**
 * Created by litong on 2018/4/7 0007.
 */
public class IndexControllerTest {
    //define server url
    private static final String server_url = "http://111.202.106.148:1026/smart-ivr/";
    private static final String internal_url = "http://localhost:8081/smart-ivr/";

    @Test
    public void proxyTest(){
        String json = getJson();
        System.out.println(json);
    }

    public String getJson(){
        String retval=null;
        //原始数据如下
        //calleeid=8200, callerid=1011, callid=ab3893de-8458-41f2-a151-f404dd10eff8, errorcode=0, flowdata=/, flowid=, notify=leave
        String calleeid = "8200";
        String callerid = "1011";
        String callid = "ab3893de-8458-41f2-a151-f404dd10eff8";
        String errorcode = "0";
        String flowdata = "/";
        String flowid = "";
        String notify = "enter";
        FirstSession firstSession = new FirstSession(calleeid, callerid, callid, errorcode, flowdata, flowid, notify);
        retval= JacksonUtil.toJson(firstSession);
        return retval;
    }
    /**
     * simulation http request test controller
     *
     * @throws Exception
     */
    @Test
    public void index() throws Exception {
        //获取对象的json字符串
        String json = getJson();
        //执行post请求
        HTTPClient.CONTENT_TYPE = MediaType.APPLICATION_JSON_UTF8_VALUE;
        String post = HTTPClient.post(internal_url,new StringEntity(json));
        System.out.println(post);
    }
}