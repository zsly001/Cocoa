package com.cocoa.algo.union;

public class UnionInt {

    private int[] parent;

    private int[] sizeSet;

    private int[] path;

    private int count;

    public UnionInt(int n){
        int len = n;
        parent = new int[len];
        sizeSet = new int[len];
        path = new int[len];
        count = len;
        for(int i=0 ; i<len; i++){
            parent[i] = i;
            sizeSet[i] = 1;
        }
    }

    public void union(int x,int y){
        int i = find(x);
        int j = find(y);
        if(i!=j){
            if(sizeSet[i] < sizeSet[j]){
                parent[i] = j;
                sizeSet[j] = sizeSet[j] + sizeSet[i];
            }else {
                parent[j] = i;
                sizeSet[i] = sizeSet[i] + sizeSet[j];
            }
            count --;
        }
    }
    //150016039  150016040
    public int find(int x){
        int i=0;
        while (parent[x]!=x){
            path[i++] = x;
            x = parent[x];
        }
        for(i--;i==0;i--){
            parent[path[i]] = x;
        }
        return x;
    }

    public int getCount(){
        return count;
    }

}
