package com.cocoa.th;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 带有前缀名的线程
 */
public class PrefixThread extends Thread{

    private static final String PREFIX = "XXX-";

    private static final AtomicInteger threadNumber = new AtomicInteger();

    private static int nextThreadNum(){
        return threadNumber.getAndIncrement();
    }

    private static String toThreadName(final Object name){
        return PREFIX+ name;
    }

    public PrefixThread() {
        super(toThreadName(nextThreadNum()));
    }

    public PrefixThread(String name) {
        super(toThreadName(name));
    }

    public PrefixThread(ThreadGroup group, String name) {
        super(group, toThreadName(name));
    }

    public PrefixThread(Runnable target) {
        super(target,toThreadName(nextThreadNum()));
    }

    public PrefixThread(Runnable target, String name) {
        super(target, toThreadName(name));
    }


    public PrefixThread(ThreadGroup group, Runnable target) {
        super(group, target,toThreadName(nextThreadNum()));
    }

    public PrefixThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, toThreadName(name));
    }

    /**
     * @param group
     * @param target
     * @param name
     * @param stackSize the desired stack size for the new thread, or zero to indicate that this parameter is to be ignored
     */
    public PrefixThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, toThreadName(name), stackSize);
    }
}
