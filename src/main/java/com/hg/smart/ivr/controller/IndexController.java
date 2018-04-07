package com.hg.smart.ivr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by litong on 2018/4/7 0007.
 */
@RestController
public class IndexController {

    @RequestMapping({"/","","index"})
    public String index(){
        return "success";
    }
}
