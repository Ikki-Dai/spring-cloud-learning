package com.ikki.cloud.feign.consumer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ikki.cloud.feign.consumer.service.HelloService;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class FeignConsumerApplication {

    private final Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private HelloService helloService;
    
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class,args);
    }

    @RequestMapping(value = "/HelloFeign", method = RequestMethod.GET)
    public String helloFeign(){
        logger.info("from browser /HelloFeign");
        return helloService.hello();
    }
    
}
