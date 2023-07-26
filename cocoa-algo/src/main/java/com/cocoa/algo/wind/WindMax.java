package com.cocoa.algo.wind;

import java.util.Arrays;
import java.util.LinkedList;

public class WindMax {

    public static int[] getMaxFromWind(int[] array,int wind){
        if(null==array || array.length==0 || array.length < wind){
            return null;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        int n = array.length;
        int r = 0;
        int i = 0;
        int[] ret = new int[n-wind+1];
        while (r < n){
            while(!qMax.isEmpty() && array[qMax.peekLast()] <= array[r]){
                qMax.pollLast();
            }
            qMax.add(r);
            if(qMax.peekFirst() == r-wind){
                qMax.pop();
            }
            if(r >= wind-1){
                ret[i++] = array[qMax.peekFirst()];
            }

            r++;
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] array = {4,3,5,4,3,3,6,7};
        int[] ret = getMaxFromWind(array, 3);
        System.out.println(Arrays.toString(ret));
    }

}
