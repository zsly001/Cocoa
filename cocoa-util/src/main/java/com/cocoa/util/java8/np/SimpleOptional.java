package com.cocoa.util.java8.np;

import java.util.Optional;

class M{}

public class SimpleOptional {


    public static void f1(){
        Optional<User> user = Optional.empty();
        System.out.println(user.isPresent());
        String a = null;
        //Optional.of(a);
        String b = "123";
        Optional<String> bo = Optional.of(b);
        System.out.println(bo);

    }

    public static int f2(int n){
        if(n<2){
            return n;
        }
        return f2(n-1)+f2(n-2);
    }





    public static void main(String[] args) {
        //f1();
        System.out.println(f2(7));
    }


}
