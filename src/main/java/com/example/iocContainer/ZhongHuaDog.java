package com.example.iocContainer;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/3/30.
 */
public class ZhongHuaDog extends Dog{

    private String color ;
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
