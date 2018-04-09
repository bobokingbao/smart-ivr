package com.hg.smart.ivr.controller;

import com.hg.smart.ivr.constant.EnterpriseInfo;
import com.hg.smart.ivr.model.FirstSession;
import com.hg.smart.ivr.model.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by litong on 2018/4/7 0007.
 */
@RestController
public class IndexController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @RequestMapping({"/","","index"})
    public ResponseData index(@RequestBody FirstSession firstSession){
        log.info("firstSession:"+firstSession.toString());
        ResponseData rd = ResponseData.getInstance(EnterpriseInfo.NAME);
        return rd;
    }
    /**
     * whether the test project is runnintg or not
     */
    @RequestMapping("hello")
    public String hello(){
        String retval="hello,I am litong,I come from Chins";
        return retval;
    }
}
