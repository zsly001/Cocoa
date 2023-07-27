package com.cocoa.algo.dynamic;

public class Bag {

    public static int getMaxValue(int[] w,int[] v,int total){

        return process(0,total,w,v);
    }

    public static int process(int i,int rest,int[] w,int[] v){
        if(i==w.length){
            return 0;
        }
        if(rest<0){
            return -1;
        }

        //要index
        int v1 = process(i+1,rest,w,v);
        int v2 = 0;
        int n = process(i+1,rest-w[i],w,v);
        if(-1 != n){
            v2 = v[i] + n;
        }
        return Math.max(v1,v2);
    }
    public static void main(String[] args) {
        int[] w = {1,3,6,9,10};
        int[] v = {20,30,12,23,6};
        int maxValue = getMaxValue(w, v, 15);
        System.out.println(maxValue);
    }

}
