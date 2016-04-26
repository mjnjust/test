package com.example.BaseKnowledge;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2016/4/19.
 */
public class Main {
	public static void main(String args[]) {
		File file = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\test1.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        if(!file1.exists()){
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter bufferedWriter = null ;
        BufferedOutputStream bufferedOutputStream = null ;
        try {
            byte[] bytes = new byte[1000*1000*500];
            for(int i=0;i<bytes.length;i++){
                bytes[i] = 12 ;
            }
            char[] chars = new char[bytes.length/2];
            for(int i=0;i<chars.length;i++){
                chars[i] = 'a' ;
            }
            long start = System.currentTimeMillis();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            long end = System.currentTimeMillis();
            System.out.println(end-start);
            bufferedWriter = new BufferedWriter(new FileWriter(file1));
            start = System.currentTimeMillis();
            bufferedWriter.write(chars);
            bufferedWriter.flush();
            end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}