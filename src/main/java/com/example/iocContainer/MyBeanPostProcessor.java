package com.example.iocContainer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Administrator on 2016/3/28.
 */
public class MyBeanPostProcessor implements BeanPostProcessor{
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(o.hashCode());
        System.out.println("a bean named "+s+" will be created!");
        return o ;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(o.hashCode());
        System.out.println("a bean named "+s+" has bean created");
        return o;
    }
}
