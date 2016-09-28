package com.example.iocContainer;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Properties;

/**
 * Created by Administrator on 2016/3/29.
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("teacher");
        System.out.println("beanclassname before change:" + beanDefinition.getBeanClassName());
        beanDefinition.setBeanClassName("Student");
        System.out.println("beanclassname after change:"+beanDefinition.getBeanClassName());
    }
}
