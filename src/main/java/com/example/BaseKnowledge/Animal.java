package com.example.BaseKnowledge;

/**
 * Created by Administrator on 2016/4/18.
 */
public abstract class Animal {
    String name ;
    Animal(){
        System.out.println(this.hashCode());
    }
    public void setName(String name) {
        this.name = name;
    }
}
