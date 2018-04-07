package com.hg.smart.ivr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by litong on 2018/4/7 0007.
 */
@SpringBootApplication
public class SmartIVRApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SmartIVRApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SmartIVRApplication.class);
    }
}
