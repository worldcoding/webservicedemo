package com.ai.service.impl;

import com.ai.service.IHelloWorld;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author chenwentao
 */
@WebService
public class HelloWorldImpl implements IHelloWorld {

    @Override
    @WebMethod
    public int sayHello(int content) {
        System.out.println("接收到的参数:"+content);
        return 213243;
    }
}
