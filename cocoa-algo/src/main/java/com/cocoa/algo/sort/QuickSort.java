package com.cocoa.algo.sort;

import com.cocoa.algo.Util;

import java.util.Arrays;

public class QuickSort {


    public static int[] dutchFlag(int[] array,int num){
        if(null==array || array.length==0){
            return null;
        }
        int left = -1;
        int right = array.length;
        int i = 0;
        while (i < right){
            if(array[i] < num){
                Util.swap(array,++left,i++);
            }else if(array[i] == num){
                i++;
            }else {
                Util.swap(array,--right,i);
            }
        }
        return new int[]{left+1,right-1};
    }


    public static void main(String[] args) {
        //int[] array = {3,7,5,8,6,3,1,2,0};//1,2,0,3,3,5,6,78
        int[] array = {1,7,3};
        int[] list = dutchFlag(array, 3);
        System.out.println(Arrays.toString(list));
    }



}
