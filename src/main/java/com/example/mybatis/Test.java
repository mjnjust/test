package com.example.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/9/25.
 */
public class Test {
    public static void main(String[] args){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("com/example/mybatis/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        Xxtest xtest = new Xxtest();
        xtest.setName("test1");
        sqlSession.insert("test.addTest",xtest);
        sqlSession.commit();
    }
}
