package com.cocoa.bean.circular;

public class CircularMain {

    public static void c1(){
        A a = new A();
        a.setA(10);
        B b = new B();
        b.setB(100);
        b.setA(a);
        a.setB(b);
        //b.setA(a);
        //System.out.println(a);
        //System.out.println(b);
    }

    public static void c11(){
        //A a = new A(10,new B(100,a));
    }


    public static void c2(){

        X x = new X();
        Y y = new Y();
        Z z = new Z();
        z.setA(10);
        z.setX(x);
        y.setZ(z);
        x.setY(y);
        //System.out.println(x);
        //System.out.println(y);
        System.out.println(z);

    }
    public static void main(String[] args) {
        c1();
        //c11();
        //c2();

    }

}
