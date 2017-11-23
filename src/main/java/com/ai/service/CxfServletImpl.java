package com.ai.service;

import com.ai.service.impl.HelloWorldImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * @author chenwentao
 */
public class CxfServletImpl extends CXFNonSpringServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void loadBus(ServletConfig sc) throws ServletException {
        super.loadBus(sc);

        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);

        ServerFactoryBean sfb = new ServerFactoryBean();
        sfb.setServiceClass(IHelloWorld.class);
        sfb.setAddress("/helloService");
        sfb.setServiceBean(new HelloWorldImpl());
        sfb.create();
    }
}
