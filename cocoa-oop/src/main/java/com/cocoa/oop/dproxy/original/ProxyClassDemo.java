package com.cocoa.oop.dproxy.original;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyClassDemo {

    static {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
    }

    public static void main(String[] args) throws Exception{

        Class<?> proxy = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);
        IHello hello = (IHello) proxy.getConstructor(InvocationHandler.class).newInstance(new HelloInterceptor(new HelloImpl()));
        hello.sayHello();



    }


}
