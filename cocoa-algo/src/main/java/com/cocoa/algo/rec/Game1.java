package com.cocoa.algo.rec;

import java.util.ArrayList;
import java.util.List;

public class Game1 {


    public static int findTheWinner(int n, int k) {
        List<Integer> rests = new ArrayList<>();
        for(int i=0;i<n;i++){
            rests.add(i+1);
        }
        return find(k,rests);
    }

    public static int find(int k,List<Integer> rests){

        if(rests.size() == 1){
            System.out.println("find :"+rests.get(0));
            return rests.get(0);
        }
        for(int j=0;j<k;j++){
            Integer d = rests.remove(0);
            if(j < k-1){
                rests.add(d);
                continue;
            }
            System.out.println("delete: "+d);
        }
        return find(k,rests);
    }


    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2));
    }

}
