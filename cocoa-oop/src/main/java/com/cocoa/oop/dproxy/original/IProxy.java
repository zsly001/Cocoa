package com.cocoa.oop.dproxy.original;

import java.util.List;

public interface IProxy {

    <T> T string();

    <T> T string(String str);

    <T> List<T> list();

}
