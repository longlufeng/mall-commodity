package com.llf;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
@EnableFeignClients
public class CommodityApplication {
	
    public static void main(String[] args) throws UnknownHostException {
    	
        SpringApplication.run(CommodityApplication.class, args);
       
        log.info("\n CommodityApplication 启动成功");
    }

}
