package com.ss.limitservice.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("limit-service")
public class LimitConfiguration {

    private int minimun;
    private int maximun;
/*
    public LimitConfiguration(int minimun, int maximun) {
        this.minimun = minimun;
        this.maximun = maximun;
    }*/

    public int getMinimun() {
        return minimun;
    }

    public void setMinimun(int minimun) {
        this.minimun = minimun;
    }

    public int getMaximun() {
        return maximun;
    }

    public void setMaximun(int maximun) {
        this.maximun = maximun;
    }
}
