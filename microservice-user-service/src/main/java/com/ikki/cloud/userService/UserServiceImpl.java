package com.ikki.cloud.userService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ikki.cloud.userService.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController(value="/user")
public class UserServiceImpl {
    
    private final Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private DiscoveryClient client;
    
    @RequestMapping(value="/{id}", method={RequestMethod.PUT,RequestMethod.DELETE})
    public void RegAndLogout(@PathVariable String id){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.debug("/user, host:"+instance.getHost()+", port:"+instance.getPort()+", service_id"+instance.getServiceId()+"##");
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public User login(User user){
        ServiceInstance instance = client.getLocalServiceInstance();
        user.setId(123);
        user.setGender(true);
        logger.debug("/user, host:"+instance.getHost()+", port:"+instance.getPort()+", service_id"+instance.getServiceId()+"##");
        return user;
    }
    
    @RequestMapping(value="/query/{id}",method=RequestMethod.GET)
    public User query(@PathVariable String id){
        logger.info(id);
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/user, host:"+instance.getHost()+", port:"+instance.getPort()+", service_id"+instance.getServiceId()+"##");
        return new User("ikki","123");
    }
    
    @RequestMapping(value="/hello",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="helloFallback")
    public String query(){
        logger.info("from feign Clients :");
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:"+instance.getHost()+", port:"+instance.getPort()+", service_id"+instance.getServiceId()+"##");
        return "Hello Feign";
    }
    
    public String helloFallback(){
        return "error : Hystrix fallback";
    }
    
}
