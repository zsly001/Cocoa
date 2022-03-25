package com.cocoa.th;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DeadLock1 {

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private List<String> list;

    public DeadLock1(List<String> list) {
        this.list = list;
    }

    public void dead(){
        lock.readLock().lock();
        for(String va : list){
            lock.writeLock().lock();
            va = va+"---";
            System.out.println(va);
            lock.writeLock().unlock();
        }
        lock.readLock().unlock();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        DeadLock1 dk = new DeadLock1(list);
        dk.dead();
    }


}
