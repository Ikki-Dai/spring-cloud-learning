package com.ikki.cloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;

public class AccessFilter extends ZuulFilter {
    
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public boolean shouldFilter() {
        // whether it would be execute;
        return false;
    }

    @Override
    public Object run() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String filterType() {
        // execute before request
        return "pre";
    }

    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return 0;
    }

}
