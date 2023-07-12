package com.cocoa.algo.union;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UnionSet<T> {

    private Map<T,Node<T>> nodeMap = new HashMap<>();

    private Map<Node<T>,Node<T>> topMap = new HashMap<>();

    private Map<Node<T>,Integer> topSize = new HashMap<>();

    public UnionSet(List<T> values){
        for(T value : values){
            Node<T> n = new Node<>(value);
            nodeMap.put(value,n);
            topMap.put(n,n);
            topSize.put(n,1);
        }
    }

    public boolean isSameSet(T v1,T v2){
        if(!nodeMap.containsKey(v1) || !nodeMap.containsKey(v2)){
            return false;
        }
        return findTop(nodeMap.get(v1)) == findTop(nodeMap.get(v2));
    }


    public void union(T v1,T v2){
        if(!nodeMap.containsKey(v1) || !nodeMap.containsKey(v2)){
            return;
        }
        Node<T> top1 = findTop(nodeMap.get(v1));
        Node<T> top2 = findTop(nodeMap.get(v2));
        if(top1 != top2){
            int s1 = topSize.get(top1);
            int s2 = topSize.get(top2);
            if(s1 > s2){
                //小 -> 大
                topMap.put(nodeMap.get(v2),top1);
                topSize.put(top1,s1+s2);
                topSize.remove(top2);
            }else {
                topMap.put(nodeMap.get(v1),top2);
                topSize.put(top2,s1+s2);
                topSize.remove(top1);
            }
        }
    }

    public Node<T> findTop(Node<T> v){
        Stack<Node<T>> stack = new Stack<>();
        Node<T> cur = v;
        while (cur != topMap.get(v)){
            stack.push(cur);
            cur = topMap.get(v);
        }
        while (!stack.isEmpty()){
            topMap.put(stack.pop(),cur);
        }
        return cur;
    }

    @Data
    @AllArgsConstructor
    public static class Node<T> {
        private T value;
    }

}
