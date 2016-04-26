package com.example.iocContainer;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Administrator on 2016/3/28.
 */
public class Student implements FactoryBean{
    static  int a = 0;
    private String name ;
    private int age ;
    private String school ;
    private String role ;

    public Object getObject() throws Exception {
        System.out.println("factory bean do create studetn"+a);
        a++;
        Student student = new Student();
        student.setAge(18);
        student.setName("张三");
        student.setRole("student");
        student.setSchool("衢州二中");
        return student ;
    }

    public Class<?> getObjectType() {
        return Student.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
