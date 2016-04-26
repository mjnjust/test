package com.example.aop;

/**
 * Created by Administrator on 2016/3/31.
 */
public class Login implements ILogin{
    public void login(User user){
        System.out.println(user.getName()+"登陆");
    }
    public StringBuffer logout(User user){
        System.out.println(user.getName()+"登出");
        return new StringBuffer("logout");
    }
}
