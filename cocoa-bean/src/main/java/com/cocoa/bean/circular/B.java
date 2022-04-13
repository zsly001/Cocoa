package com.cocoa.bean.circular;

public class B {

    private int b;

    private A a;

    public B() {
    }

    public B(int b, A a) {
        this.b = b;
        this.a = a;
    }

    @Override
    public String toString() {
        return "B{" +
                "b=" + b +
                ", a=" + a +
                '}';
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
