package com.example.BaseKnowledge;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2016/4/18.
 */
public class Dog  implements Serializable{
    static final long serialVersionUID = 2016041901 ;
    String name ;
    public Dog(String name){
        this.name = name ;
    }
    public static void main(String args[]){
        ObjectOutputStream out = null ;
        try {
            Socket socket = new Socket("127.0.0.1",10000);
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(new Dog("hello"));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}