package com.cocoa.oop.dproxy.original;

import java.lang.reflect.Proxy;

public class BeanProxyMain {

    static void hello(){
        IHello hello = (IHello) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{IHello.class},
                new BeanProxy<>(IHello.class));
        System.out.println(hello.hello());
    }


    static void mapper(){
        XxxMapper mapper = (XxxMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{XxxMapper.class},
                new BeanProxy<>(XxxMapper.class));
        System.out.println(mapper.info());
    }

    public static void main(String[] args) {
        hello();
        mapper();


    }

}
