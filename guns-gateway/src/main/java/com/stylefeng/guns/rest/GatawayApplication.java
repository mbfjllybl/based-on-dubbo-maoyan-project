package com.stylefeng.guns.rest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.stylefeng.guns.api.user.UserAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.jws.soap.SOAPBinding;

@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns"})
@EnableDubboConfiguration
@EnableAsync
public class GatawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatawayApplication.class, args);
    }
}
