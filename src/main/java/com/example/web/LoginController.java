package com.example.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/4/7.
 */
@Controller//声明这是一个Controller类，这样服务器初始化的时候就能被spring容器识别
@RequestMapping(value = "/req")//这是声明请求的名称（路径）用的
public class LoginController {
    @RequestMapping(value = "/login.do",method = RequestMethod.GET)//和前一个requestmapping组合形成了名为/req/login.do的请求
    public Object login(@RequestParam String name, @RequestParam String password){//表示这个请求接收名为name和password的参数
        String data_password = getPasswordByName(name);
        if(password.equals(data_password)){
            return "index" ;//返回字符串index，它的本意是向返回一个index.html页面
        }else{
            return "login" ;//如果密码不对，就返回login.html页面
        }
    }
    String getPasswordByName(String name){//根据名称获取密码
        return "admin" ;
    }
}