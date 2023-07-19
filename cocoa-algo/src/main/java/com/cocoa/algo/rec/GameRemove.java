package com.cocoa.algo.rec;

import java.util.ArrayList;
import java.util.List;

public class GameRemove {


    public static int lastRemaining(int n){
        List<Integer> rests = new ArrayList<>();
        for(int i=0; i<n; i++){
            rests.add(i+1);
        }
        return win(rests,0);
    }

    public static int win(List<Integer> rests,int index){
        if(rests.size() == 1){
            return rests.get(0);
        }
        int length = rests.size();
        //int size = (int)Math.ceil(length/2.0);
        if(index==0){
            for(int i=0;i<=length;i++){
                Integer r = rests.remove(0);
                if(i%2 == 0){
                    System.out.println("delete : "+r);
                }else {
                    rests.add(r);
                }
            }
            System.out.println("---------");
            return win(rests,rests.size());
        }else {
            for(int i=length;i>=0;i--){
                Integer r = rests.remove(rests.size()-1);
                if(i%2 == 0){
                    System.out.println("delete : "+r);
                }else {
                    rests.add(0,r);
                }
            }
            System.out.println("++++++++");
            return win(rests,0);
        }
    }


    public static void main(String[] args) {
        int winner = lastRemaining(9);
        System.out.println(winner);
        /*for(int i=0;i<9;i++){
            System.out.println(i%2);
        }*/
    }

}
