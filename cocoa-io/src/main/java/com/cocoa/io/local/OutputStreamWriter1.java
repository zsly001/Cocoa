package com.cocoa.io.local;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * 抄录自log4j2-2.7.1
 * @link org.apache.logging.log4j.core.appender.OutputStreamManager
 *
 * 使用OutputStream写入ByteBuffer的数据。类似于BufferedOutputStream类，
 * 但是BufferedOutputStream类使用的byte[]数组作为数据缓存
 * 而本类使用ByteBuffer作为缓存。
 * 通过本例要深刻理解缓存行带来性能提升的原理.即流的写入只能每次写一个byte,write(int v),只会写入低8位,忽略高24位.该方法是本地方法;
 * 缓存提升的方法是,每次写数据时,都会先尝试将数据放入缓存行,如果放不下则先清空再放入缓存行.避免每写一个byte时都真实触发写操作.而是积攒
 * 一批,待满足条件一次写入.注意这里的一次写入实际上也是一条条依次写入.而缓存行可以减少触发本地调用量，达到提升性能的目的
 * 每个流(OutputStream)都唯一指定一个文件描述符,该文件描述符可以是一个文件,一个socket等.在写入数据时可能一次也可能多次写入,这些写入
 * 操作可能在同一个线程也可能在多个线程中.每次写时会涉及缓存行的修改,需要加锁才能保证数据顺序不会背破坏.
 *
 *
 */
public class OutputStreamWriter1 {

    private OutputStream outputStream;

    private ByteBuffer byteBuffer;


    public OutputStreamWriter1(OutputStream os, ByteBuffer bf) {
        this.outputStream = Objects.requireNonNull(os,"OutputStream is null");
        this.byteBuffer = Objects.requireNonNull(bf,"ByteBuffer is null");
    }


    public void write(final byte[] bytes){
        write(bytes,0,bytes.length,false);
    }

    public void write(final byte[] bytes,boolean immediateFlush){
        write(bytes,0,bytes.length,true);
    }


    private synchronized void write(final byte[] bytes,final int offset,final int length,final  boolean immediateFlush){

        if(immediateFlush&&byteBuffer.position()==0){
            writeDestination(bytes,offset,length);
            flushDestination();
            return;
        }
        if(length >= byteBuffer.capacity()){
            flush();
            writeDestination(bytes,offset,length);
        }else {
            if(length > byteBuffer.remaining()){
                flush();
            }
            byteBuffer.put(bytes,offset,length);
        }
        if(immediateFlush){
            flush();
        }
    }

    private synchronized void writeDestination(final byte[] bytes, final int offset, final int length){
        try {
            outputStream.write(bytes,offset,length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private synchronized void flush(){
        flushBuffer(this.byteBuffer);
        flushDestination();
    }

    private synchronized void flushDestination(){
        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void flushBuffer(final ByteBuffer buf){
        buf.flip();
        try {
            if(buf.remaining()>0){
                writeDestination(buf.array(),buf.arrayOffset()+buf.position(),buf.remaining());
            }
        } finally {
            buf.clear();
        }
    }




}
