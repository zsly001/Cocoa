package com.cocoa.oop.dproxy.original;

public class HelloImpl implements IHello{

    @Override
    public String sayHello() {
        return "hello";
    }

    @Override
    public String say(String msg) {
        return "[hello]"+msg;
    }
}
