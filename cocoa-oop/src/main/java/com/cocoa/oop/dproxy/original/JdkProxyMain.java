package com.cocoa.oop.dproxy.original;

import java.lang.reflect.Proxy;

public class JdkProxyMain {


    public static void main(String[] args) {
        IHello hello = (IHello)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{IHello.class},
                new HelloInterceptor(new HelloImpl()));

        System.out.println(hello.sayHello());

        System.out.println(hello.say("haha"));

        System.out.println(hello.toString());
    }


}
