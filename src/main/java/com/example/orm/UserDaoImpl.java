package com.example.orm;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2016/4/5.
 */
public class UserDaoImpl implements IUserDao{
    private SessionFactory sessionFactory ;
    private Session session ;
    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-main.xml");
        IUserDao userDao = (IUserDao) app.getBean("userdao");
        User[] users = userDao.getUsers();
        System.out.println(users.length);
    }
    public User[] getUsers() {
        String hql = "from User" ;
        Query query = session.createQuery(hql);
        List list = query.list();
        if (list==null||list.size()==0){
            return null;
        }else {
            User[] users = new User[list.size()];
            for(int i=0;i<users.length;i++){
                users[i] = (User) list.get(i);
            }
            return users ;
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = this.sessionFactory.openSession();
    }
}
