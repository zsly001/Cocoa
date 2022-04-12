package com.cocoa.oop.dproxy.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkMethodInterceptor implements InvocationHandler {

    private Method originalMethod;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
