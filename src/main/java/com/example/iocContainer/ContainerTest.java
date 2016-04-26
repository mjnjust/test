package com.example.iocContainer;

import com.example.aop.ILogin;
import com.example.aop.Login;
import com.example.aop.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * Created by Administrator on 2016/3/28.
 */
public class ContainerTest {
    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-main.xml");
        ILogin login = (ILogin) app.getBean("login");
        User user = new User();
        user.setName("mj");
        login.login(user);
    }
}
