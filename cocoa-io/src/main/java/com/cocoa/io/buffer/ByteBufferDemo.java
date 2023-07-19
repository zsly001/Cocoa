package com.cocoa.io.buffer;

import org.apache.commons.io.IOUtils;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ByteBufferDemo {

    public void f(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello".getBytes(StandardCharsets.UTF_8));
        buffer.put("world".getBytes(StandardCharsets.UTF_8));
    }

}
