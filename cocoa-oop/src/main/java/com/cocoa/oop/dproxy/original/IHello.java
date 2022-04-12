package com.cocoa.oop.dproxy.original;

public interface IHello {

    String sayHello();

    String say(String msg);

    default String hello(){
        return "hello";
    }

}
