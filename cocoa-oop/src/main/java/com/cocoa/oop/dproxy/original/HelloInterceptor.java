package com.cocoa.oop.dproxy.original;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloInterceptor implements InvocationHandler {

    private Object original;

    public HelloInterceptor() {
    }

    public HelloInterceptor(Object original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = proxy.getClass().getSimpleName()+"#"+method.getName();
        System.out.println("[before]-"+name);
        Object result = method.invoke(original, args);
        System.out.println("[after]-"+name);
        return result;
    }
}
