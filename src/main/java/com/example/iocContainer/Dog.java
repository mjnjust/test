package com.example.iocContainer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/3/29.
 */
@Component("dog")
public class Dog {
    @Value("lili")
    private String name ;
    @Value("15.4")
    private double weight ;

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
