package com.ai.service;

import org.apache.axis.wsdl.symbolTable.Parameter;
import org.apache.axis.wsdl.symbolTable.Parameters;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class WebServiceUtil {
    public static Object Invoke(String wsdlUrl,String serviceName,String operationName,Object[] objects)
            throws Exception{

        DynamicInvoker invoker = new DynamicInvoker(wsdlUrl);
        Vector V = invoker.enumPortNames(serviceName);
        String portName = (String) V.elementAt(0);
        Parameters parameters = invoker.enumParameters(serviceName, portName, operationName);
        Vector v = parameters.list;
        Vector parameterValues = new Vector();
        for (int k = 0; k < v.size(); k++) {
            Parameter para = (Parameter) v.elementAt(k);
            System.out.println(para.getQName().getLocalPart());
            if (para.getType().getQName().getLocalPart().equals("string")) {
                parameterValues.addElement(objects[k]);
            } else {
                parameterValues.addElement(objects[k].toString());
            }
        }
        Map result = invoker.invoke(serviceName, portName, operationName, parameterValues);

        Iterator it = result.keySet().iterator();
        String name = (String) it.next();
        Object value = result.get(name);

        return value;
    }
}
