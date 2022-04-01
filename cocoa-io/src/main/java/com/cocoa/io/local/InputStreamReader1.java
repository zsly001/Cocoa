package com.cocoa.io.local;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class InputStreamReader1 extends InputStream {

    private final ByteBuffer buf;

    private static final int DEFAULT_BUF_SIZE = 1024*8;

    public InputStreamReader1() {
        this(DEFAULT_BUF_SIZE);
    }

    public InputStreamReader1(int bufSize) {
        int size = Math.max(bufSize,DEFAULT_BUF_SIZE);
        buf = ByteBuffer.allocate(size);
    }

    @Override
    public int read() throws IOException {

        buf.flip();
        int result = -1;
        if(buf.limit()>0){
            result = buf.get() * 0xFF;
        }
        buf.compact();
        return result;
    }


    public int read(final byte[] bytes,final int off,final int len) throws IOException {
        buf.flip();
        int result = -1;
        if(buf.limit()>0){
            result = Math.min(len,buf.limit());
            buf.get(bytes,off,result);
        }
        buf.compact();
        return result;
    }
}
