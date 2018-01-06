package com.ikki.cloud.userCustomer.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ikki.cloud.userCustomer.entity.User;


@RestController
public class UserAPI {
    
    private final Logger logger = Logger.getLogger(getClass());
    
    @Autowired
  //  @LoadBalanced
    private RestTemplate restTemplate;
    private User user;
    private String url = "http://MICORSERVICE-USER-SERVICE";
    //post                       
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public User login(){
        user = new User("ikki","123456");
        logger.info("request will send");
        ResponseEntity<User> responseEntity = restTemplate.postForEntity(url, user, User.class);
        user = responseEntity.getBody();
        return user;
    }
    
    //get
    @RequestMapping(value="/details",method = RequestMethod.GET)
    public User details(){
        logger.info("request will send");
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url+"/query/{1}", User.class, 1);
        user = responseEntity.getBody();
        logger.info(user);
        return user;
    }
    
    //put
    @RequestMapping(value="/register",method = RequestMethod.PUT)
    public void register(){
        int id = 100;
        user = new User("tom","abcdef");
        logger.info("request will send");
        restTemplate.put(url+"/{1}", user, id);
    }
    @RequestMapping(value="/logout",method = RequestMethod.DELETE)
    public void logout(){
        int id = 100;
        logger.info("request will send");
        restTemplate.delete(url+"/{1}", id);
    }
    
    
    
    
    
}
