package com.cocoa.oop.dproxy.original;

import java.util.List;

public class DefaultProxyIntance implements IProxy{

    @Override
    public <T> T string() {
        return null;
    }

    @Override
    public String string(String str) {
        return "default-proxy : [ "+str+" ]";
    }

    @Override
    public <T> List<T> list() {
        return null;
    }
}
