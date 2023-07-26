package com.cocoa.algo.union;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*List<String> values = Arrays.asList("a","b","c","d","e","f","g");
        UnionSet<String> us = new UnionSet<>(values);
        System.out.println("a isSame e = "+us.isSameSet("a","e"));

        us.union("a","b");
        us.union("b","c");
        System.out.println("a isSame c = "+us.isSameSet("a","c"));*/

        /*UnionInt un = new UnionInt(10);
        un.union(0,3);
        un.union(5,7);
        un.union(5,9);
        System.out.println("count: "+un.getCount());*/

        //int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,0};
        System.out.println(longestConsecutive(nums));


    }


    public static int longestConsecutive(int[] nums) {
        Union un = new Union(nums);
        for(int num : nums){
            un.union(num-1,num);
            un.union(num+1,num);
        }
        return un.getMaxLen();
    }

}
