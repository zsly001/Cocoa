package com.cocoa.oop.dproxy.original;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanProxy<T> implements InvocationHandler {

    private static final Constructor<MethodHandles.Lookup> lookupConstructor;
    private static final Method privateLookupInMethod;
    private final Class<T> mapperInterface;

    static {
        Method privateLookupIn;
        try {
            privateLookupIn = MethodHandles.class.getMethod("privateLookupIn", Class.class, MethodHandles.Lookup.class);
        } catch (NoSuchMethodException var5) {
            privateLookupIn = null;
        }
        privateLookupInMethod = privateLookupIn;
        Constructor<MethodHandles.Lookup> lookup = null;
        if (privateLookupInMethod == null) {
            try {
                lookup = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                lookup.setAccessible(true);
            } catch (NoSuchMethodException var3) {
                throw new IllegalStateException("There is neither 'privateLookupIn(Class, Lookup)' nor 'Lookup(Class, int)' method in java.lang.invoke.MethodHandles.", var3);
            } catch (Exception var4) {
                lookup = null;
            }
        }
        lookupConstructor = lookup;
    }

    public BeanProxy(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if(method.isDefault()){
            result = new DefaultInvoker(getMethodHandleJava8(method)).invoke(proxy,method,args);
        }
        return result;
    }

    private MethodHandle getMethodHandleJava8(Method method)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        final Class<?> declaringClass = method.getDeclaringClass();
        return lookupConstructor.newInstance(declaringClass, 15).unreflectSpecial(method, declaringClass);
    }

    class DefaultInvoker implements Invoker{
        private final MethodHandle methodHandle;

        public DefaultInvoker(MethodHandle methodHandle) {
            this.methodHandle = methodHandle;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return this.methodHandle.bindTo(proxy).invokeWithArguments(args);
        }
    }

    class PlainInvoker implements Invoker{



        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }

    interface Invoker{
        Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
    }

}
