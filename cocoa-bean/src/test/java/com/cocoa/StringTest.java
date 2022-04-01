package com.cocoa;

import org.junit.Test;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class StringTest {


    @Test
    public void characterIterator(){

        String str1 = "jsdjkfl{sdf:sdf}asdklj12321.sd,f";
        StringCharacterIterator iterator = new StringCharacterIterator(str1);
        System.out.println("first is "+ iterator.first());
        System.out.println("last is "+ iterator.last());
        while (CharacterIterator.DONE != iterator.current()){
            System.out.println(iterator.current());
            System.out.println("next is "+iterator.next());
        }

    }


    @Test
    public void traverseForward(){
        String str = "jalfsdkjl.09023()3212kk";
        StringCharacterIterator iterator = new StringCharacterIterator(str);
        for(char c = iterator.first();c!=CharacterIterator.DONE;c = iterator.next() ){
            System.out.println(c);
        }
    }


    @Test
    public void traverseBackward(){
        String str = "jalfsdkjl.09023()3212kk";
        StringCharacterIterator iterator = new StringCharacterIterator(str);
        for(char c = iterator.last();c!=CharacterIterator.DONE;c = iterator.previous() ){
            System.out.println(c);
        }
    }
}
