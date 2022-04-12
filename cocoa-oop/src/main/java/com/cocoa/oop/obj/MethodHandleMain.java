package com.cocoa.oop.obj;

import com.cocoa.oop.dproxy.original.HelloImpl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleMain {

    public static void main(String[] args) throws Throwable{
        MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
        MethodType mt = MethodType.methodType(String.class, String.class);
        MethodHandle handle = publicLookup.findVirtual(HelloImpl.class, "say", mt);
        HelloImpl instance = HelloImpl.class.getConstructor().newInstance();
        Object result = handle.bindTo(instance).invoke("hehe");
        String good = (String)handle.bindTo(instance).invokeExact("good");
        //String result = (String) handle.invoke("hehehe");
        System.out.println(result);
        System.out.println(good);
    }



}
