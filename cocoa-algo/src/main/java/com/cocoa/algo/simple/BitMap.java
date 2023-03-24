package com.cocoa.algo.simple;

public class BitMap {

    private long[] bitMap;

    public BitMap(int max) {
        bitMap = new long[(max + 64) >> 6];
    }

    public void add(int n){
        bitMap[n >> 6] |= 1L << (n & 63);
    }

    public void remove(int n){
        bitMap[n >> 6] &= ~(1L << (n & 63));
    }

    public boolean contains(int n){
        return (bitMap[n >>6] & (1L << (n & 63))) != 0;
    }

    public static void main(String[] args) {
        BitMap bm = new BitMap(128);
        bm.add(1);
        bm.add(121);
        bm.add(27);
        bm.remove(121);
        System.out.println(bm.contains(1));
        System.out.println(bm.contains(121));
    }

}
