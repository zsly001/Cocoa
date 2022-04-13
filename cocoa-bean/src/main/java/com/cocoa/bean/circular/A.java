package com.cocoa.bean.circular;

public class A {

    private int a;

    private B b;

    public A() {
    }

    public A(int a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
