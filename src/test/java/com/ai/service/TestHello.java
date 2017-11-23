package com.ai.service;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.junit.Test;

import javax.xml.namespace.QName;

public class TestHello {

    @Test
    public void testSayHello() throws Exception {
        Object str = WebServiceUtil.Invoke("http://192.168.3.110:8080/helloService?wsdl",
                "IHelloWorld","sayHello",new Object[]{123});
        System.out.println(str);
    }

    public static void main(String[] args) throws Exception {
        try {
            Object[] param = new Object[] { 1234 };
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress("http://192.168.3.110:8080/helloService?wsdl");
            //call.setOperationName("sayHello");
            call.setOperationName(new QName("http://192.168.3.110:8080/","sayHello"));
            call.setUseSOAPAction(true);

            String result = (String) call.invoke(param);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}