package com.ai.service.publish;

import com.ai.service.impl.HelloWorldImpl;

import javax.xml.ws.Endpoint;

/**
 * @author chenwentao
 */
public class PublishHello {
    public static void main(String[] args){
        Endpoint.publish("http://127.0.0.1:8080/hello" , new HelloWorldImpl());
        System.out.println("发布webservice成功!");
    }
}
