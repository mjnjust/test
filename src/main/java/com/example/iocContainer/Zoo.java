package com.example.iocContainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/3/29.
 */
public class Zoo {
    private Dog dog ;
    public Dog getDog() {
        return dog;
    }
    public void setDog(Dog dog) {
        this.dog = dog;
    }
    private ZhongHuaDog zhongHuaDog ;
    public ZhongHuaDog getZhongHuaDog() {
        return zhongHuaDog;
    }
    public void setZhongHuaDog( ZhongHuaDog zhongHuaDog) {
        this.zhongHuaDog = zhongHuaDog;
    }
}
