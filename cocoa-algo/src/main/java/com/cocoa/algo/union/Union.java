package com.cocoa.algo.union;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Union {

    private int[] parents;

    private int[] sizeMap;

    private Map<Integer,Integer> nodesMap;

    private int maxLen;

    public Union(int[] nums){
        int len = nums.length;
        parents = new int[len];
        sizeMap = new int[len];
        nodesMap = new HashMap<>();
        for(int i = 0; i < len; i++){
            parents[i] = i;
            sizeMap[i] = 1;
            nodesMap.put(nums[i],i);
        }
    }

    public void union(int a,int b){
        if(!nodesMap.containsKey(a) || !nodesMap.containsKey(b)){
            return;
        }
        int ap = find(a);
        int bp = find(b);
        if(ap != bp){
            int as = sizeMap[ap];
            int bs = sizeMap[bp];
            int size = as + bs;
            maxLen = Math.max(maxLen,size);
            if(as >= bs){
                parents[bp] = ap;
                sizeMap[ap] = size;
            }else {
                parents[ap] = bp;
                sizeMap[bp] = size;
            }
        }
    }

    public int find(int idx){
        Stack<Integer> stack = new Stack<>();
        while (parents[idx] != idx){
            stack.push(idx);
            idx = parents[idx];
        }
        while (!stack.isEmpty()){
            parents[stack.pop()] = idx;
        }
        return idx;
    }

    public int getMaxLen(){
        return maxLen;
    }


}
