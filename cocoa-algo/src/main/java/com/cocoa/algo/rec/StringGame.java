package com.cocoa.algo.rec;

import java.util.ArrayList;
import java.util.List;

public class StringGame {

    /**
     * 所有字串
     * @param str
     */
    public static void printSubStr(String str){
        char[] strs = str.toCharArray();
        subStr(strs);
    }

    /**
     * 递归字串
     * @param str
     */
    public static void printSubStr2(String str){
        char[] strs = str.toCharArray();
        List<String> all = new ArrayList<>();
        subStr2(strs,0,all,"");
        all.stream().forEach(System.out::println);
    }

    /**
     * 子序列
     * @param str
     */
    public static void printSubSeq(String str){
        char[] strs = str.toCharArray();
        List<String> all = new ArrayList<>();
        subSeq(strs,0,all,"");
        all.stream().forEach(System.out::println);
    }

    /**
     * 全排列
     * @param str
     */
    public static void printFullSort(String str){

    }
    private static void subStr(char[] strs){
        int Len = strs.length;
        List<String> all = new ArrayList<>();
        for(int i=0;i<Len;i++){
            StringBuilder str = new StringBuilder(Character.toString(strs[i]));
            all.add(str.toString());
            for(int j=i+1;j<Len;j++){
                str.append(strs[j]);
                all.add(str.toString());
            }
        }
        all.stream().forEach(System.out::println);
    }

    private static void subStr2(char[] strs,int index,List<String> all,String path){
        if(index == strs.length){
            return;
        }
        int next = index;
        StringBuilder sb = new StringBuilder(path);
        do{
            sb.append(Character.toString(strs[next++]));
            all.add(sb.toString());
        }while (strs.length - next >0);
        subStr2(strs,index+1,all,path);
    }

    private static void subSeq(char[] strs,int index,List<String> all,String path){
        if(index == strs.length){
            all.add(path);
            return;
        }
        String yes = path + Character.toString(strs[index]);
        subSeq(strs,index+1,all,yes);
        String no = path;
        subSeq(strs,index+1,all,no);
    }


    private static void fullSort(){

    }

    public static void main(String[] args) {
        String str1 = "abc";
        //printSubStr(str1);
        //printSubStr2(str1);
        printSubSeq(str1);
    }

}
