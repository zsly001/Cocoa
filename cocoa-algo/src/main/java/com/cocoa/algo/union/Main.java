package com.cocoa.algo.union;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> values = Arrays.asList("a","b","c","d","e","f","g");
        UnionSet<String> us = new UnionSet<>(values);
        System.out.println("a isSame e = "+us.isSameSet("a","e"));

        us.union("a","b");
        us.union("b","c");
        System.out.println("a isSame c = "+us.isSameSet("a","c"));
    }


}
