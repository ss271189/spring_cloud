package com.ss.limitservice.controller;


import com.ss.limitservice.bean.Limits;
import com.ss.limitservice.config.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {


    @Autowired
    LimitConfiguration limitConfiguration;

    @GetMapping(path = "/limits")
    public Limits getLimit(){
        return new Limits(limitConfiguration.getMinimun(),limitConfiguration.getMaximun());
    }


}
