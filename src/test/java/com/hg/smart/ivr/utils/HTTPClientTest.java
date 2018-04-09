package com.hg.smart.ivr.utils;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by litong on 2018/4/9 0009.
 */
public class HTTPClientTest {
    /**
     * test post request
     */
    @Test
    public void testPost(){

    }

    /**
     * test get requdst
     */
    @Test
    public void testGet(){
        String server_url="http://111.202.106.148:8081";
        String s = null;
        try {
            s = HTTPClient.get(server_url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}