package com.selfish.gene.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by Administrator on 2017/1/8.
 */
public class FileChannelTest {
    public static void main(String[] args) throws Exception {
        String readPath = "D:\\git\\accumulation\\src\\main\\java\\com\\my\\io\\nio\\FileChannelTest.java";
        String outPath = "D:\\git\\accumulation\\src\\main\\resources\\io\\nio\\channel.txt";
        File f = new File(readPath);
        try (
                FileChannel inChannel = new FileInputStream(f).getChannel();
                FileChannel outChannel = new FileOutputStream(outPath).getChannel();
        ) {
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());

            Charset charset = Charset.forName("GBK");

            outChannel.write(buffer);
            buffer.clear();

            CharsetDecoder decoder = charset.newDecoder();

            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

}
