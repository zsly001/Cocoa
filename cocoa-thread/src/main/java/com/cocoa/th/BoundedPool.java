package com.cocoa.th;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class BoundedPool<T> {

    private Semaphore limit;

    private List<T> pools;

    private Object lock = new Object();


    public BoundedPool() {
        this(6);
    }

    public BoundedPool(int limit) {
        this.limit = new Semaphore(limit);
        pools = new ArrayList<>();
    }

    public void put(T data){
        if(null == data){
            return;
        }
        try {
            limit.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            pools.add(data);
        }

    }

    public T pop(){
        if(pools.isEmpty()){
            return null;
        }
        T data;
        synchronized (lock) {
            data = pools.remove(0);
        }
        limit.release();
        return data;
    }

    public int size(){
        synchronized (lock) {
            return pools.size();
        }
    }


    public static void main(String[] args) {

        Random random = new Random();
        BoundedPool<String> pool = new BoundedPool<>(3);
        new Thread(new Task(pool,1,random.nextInt(100)),"Ta").start();
        new Thread(new Task(pool,1,random.nextInt(200)),"Tb").start();
        new Thread(new Task(pool,1,random.nextInt(10)),"Tc").start();
        new Thread(new Task(pool,1,random.nextInt(500)),"Td").start();
        new Thread(new Task(pool,1,random.nextInt(100)),"Te").start();
        new Thread(new Task(pool,1,random.nextInt(300)),"Tf").start();
        new Thread(new Task(pool,0,random.nextInt(600)),"C").start();

    }

    public static class Task implements Runnable{

        private BoundedPool<String> pool;

        private int mills;

        private int mode;

        public Task(BoundedPool<String> pool, int mode,int mills) {
            this.pool = pool;
            this.mode = mode;
            this.mills = mills;
        }

        @Override
        public void run() {
            if(mode == 1){
                for (int i=0;i<10;i++){
                    pool.put(Thread.currentThread().getName()+i);
                    try {
                       Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"-end");
            }else {

                while (true){
                    String v = pool.pop();
                    System.out.println(Thread.currentThread().getName()+": pool size is "+pool.size()+",data is "+v);
                    try {
                        Thread.sleep(mills);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

}
