package com.ikki.cloud.feign.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("MICORSERVICE-USER-SERVICE")
public interface HelloService {
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();
    
}
