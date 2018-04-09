package com.hg.smart.ivr.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * Created by Administrator on 2018/4/7 0007.
 */
public class ResponseDataTest {

    /**
     * test getInstance mothod
     * @throws Exception
     * {"action":"start_asr","after_action":"playback","flowdata":"/","after_ignore_error":false,"params":{"min_speak_ms":"100","max_speak_ms":"1000","min_pause_ms":"300","max_pause_ms":"600","pause_play_ms":"200","threshold":"0","recordpath":"","volume":"50"},"after_params":{"prompt":"hello,World","wait":"5000","retry":"0"}}
     */
    @Test
    public void getInstance() throws Exception {
        ResponseData rd = ResponseData.getInstance("hello,World");
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(rd);
        System.out.println(s);
    }
}