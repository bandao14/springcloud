package com.zl;

import com.zl.filter.ServiceFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulRun {

    public static void main(String[] args) {
        SpringApplication.run(ZuulRun.class,args);
    }
    @Bean
    public ServiceFilter serviceFilter(){
        return new ServiceFilter();
    }
}
