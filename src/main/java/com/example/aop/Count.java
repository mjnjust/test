package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Administrator on 2016/3/31.
 */
public class Count {
    static int number = 0;
    public void beforeuserlogin(JoinPoint joinPoint){
        number++;
        System.out.println("获取切入点的信息,切入点所在类："+joinPoint.getThis());
        System.out.println("当前在线人数："+number);
    }
    public void afteruserlogin(User user){
        System.out.println(user.getName()+"  login end");
    }
    public Object aroundlogout(ProceedingJoinPoint joinPoint){
        System.out.println("logout start");
        System.out.println("获取切入点的信息,切入点所在类："+joinPoint.getThis());
        Object object = null;
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        number--;
        System.out.println("logout end");
        System.out.println("当前在线人数:"+number);
        return object;
    }
    public void afterReturn(StringBuffer s){
        s.append(" after return");
    }
}
