package com.my.io;


import java.io.*;

/**
 * Created by Administrator on 2016/12/22.
 */
public class IOTest {

    private static final PrintStream out = System.out;

    public static void main(String[] args) throws Exception{
        // TODO  How to obtain the current class path in Java?
        //The location of the binary file   /D:/git/accumulation/target/classes/com/my/io/
        String fileLocation = IOTest.class.getResource("").getPath();
        //The location of the binary directory   /D:/git/accumulation/target/classes/
        String classDirLocation = IOTest.class.getResource("/").getPath();

        String src = "D:\\git\\accumulation\\src\\main\\java\\com\\my\\io\\IOTest.java";
        String dest = "D:\\git\\accumulation\\src\\main\\resources\\newFile.txt";
        //getFileInputStream(src);
        //getFileRead(src);
        readAndWriteByStream(src, dest);
    }

    private static void getFileInputStream(String filePath) throws IOException {
        FileInputStream in = new FileInputStream(filePath);
        byte[] bytes = new byte[1024];
        int hasRead = 0;
        while((hasRead = in.read(bytes)) > 0){
            out.println(new String(bytes, 0, hasRead));// The bytes to be decoded into characters
        }
        in.close();
    }

    private static void getFileRead(String filePath){
        try (
                FileReader reader = new FileReader(filePath)
        ){
            char[] chars = new char[32];
            int hasRead = 0;
            while((hasRead = reader.read(chars)) > 0){
                out.print(new String(chars, 0, hasRead));
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private static void readAndWriteByStream(String src, String dest){
        try (
                FileInputStream in = new FileInputStream(src);
                FileOutputStream out = new FileOutputStream(dest)
                ){
            byte[] bytes = new byte[1024];
            int hasRead = 0;
            while((hasRead = in.read(bytes)) > 0){
                out.write(bytes, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
