package com.cocoa.algo.wind;

import java.util.*;

public class QStack {


    /**
     * 单调栈 无重复数字 给出数组中任意位置中,左边距离最近比它小的数和右边距离最近比它小的数
     * @return map<list<int>></> 表示输入数组的左右值,a=[left,right]
     */
    public static Map<Integer,List<Integer>> getStackMin(int[] array){
        if(null == array || array.length==0){
            return null;
        }
        Map<Integer,List<Integer>> ret = new LinkedHashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < array.length; i++){
            while (!stack.isEmpty() && array[stack.peek()]>array[i]){
                Integer idx = stack.pop();
                int left = stack.isEmpty()?-1:array[stack.peek()];
                int right = i;
                ret.put(array[idx],Arrays.asList(left,array[right]));
            }
            stack.add(i);
        }
        if(!stack.isEmpty()){
            while (!stack.isEmpty() ){
                Integer idx = stack.pop();
                int left = stack.isEmpty()?-1:array[stack.peek()];
                ret.put(array[idx],Arrays.asList(left,-1));
            }
        }
        return ret;
    }


    public static Map<String,List<Integer>> getStackMinDuplicate(int[] array){
        if(null == array || array.length==0){
            return null;
        }
        Map<String,List<Integer>> ret = new LinkedHashMap<>();
        Stack<LinkedList<Integer>> stack = new Stack<>();
        for(int i=0;i<array.length;i++){
            while (!stack.isEmpty() && array[stack.peek().peekLast()]>array[i]){
                LinkedList<Integer> ids = stack.pop();
                int left = stack.isEmpty() ? -1 : array[stack.peek().peekLast()];
                int right = array[i];
                for(Integer idx : ids){
                    ret.put(array[idx]+"_"+idx,Arrays.asList(left,right));
                }
            }

            if(!stack.isEmpty() && array[stack.peek().peekLast()] == array[i]){
                stack.peek().add(i);
            }else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.add(list);
            }
        }
        if(!stack.isEmpty()){
            while (!stack.isEmpty()){
                LinkedList<Integer> ids = stack.pop();
                int left = stack.isEmpty() ? -1 : array[stack.peek().peekLast()];
                int right = -1;
                for(Integer idx : ids){
                    ret.put(array[idx]+"_"+idx,Arrays.asList(left,right));
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] array = {1,3,2,5,8,7,11,10,16,12};
        Map<Integer, List<Integer>> min1 = getStackMin(array);
        Map<String, List<Integer>> min2 = getStackMinDuplicate(array);
        System.out.println(min1);
        System.out.println(min2);
    }

}
