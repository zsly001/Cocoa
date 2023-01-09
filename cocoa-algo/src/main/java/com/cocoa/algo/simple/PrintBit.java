package com.cocoa.algo.simple;

public class PrintBit {

    public static String printBitInteger(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=31;i>=0;i--){
            if((n & (1<<i))==0){
                sb.append("0");
            }else {
                sb.append("1");
            }
        }
        return sb.toString();
    }

    public static String printBitLong(long n){
        StringBuilder sb = new StringBuilder();
        for(long i = 63L; i>= 0L; i--){
            sb.append((n & (1L<<i)) == 0L ? "0" : "1");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a = 1;
        int n = 63;
        int value = a | n;
        System.out.println(printBitInteger(a));
        System.out.println(printBitInteger(n));
        System.out.println(printBitInteger(value));
        System.out.println(value);
        System.out.println(printBitLong((1L<<42L)));
        System.out.println(printBitLong(~(1L<<42L)));
        //System.out.println(printBitLong(Long.MIN_VALUE));
    }

}
