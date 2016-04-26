package com.example.resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.*;

/**
 * Created by Administrator on 2016/3/30.
 */
public class ResourceTest {
    @Test
    public void test() throws IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-main.xml");
        Resource resource = app.getResource("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=980636662,4189144925&fm=58");
        File file = new File("C:\\Users\\Administrator\\Desktop\\pg.jpg");
        InputStream inputStream = resource.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\pg2.jpg");
        if(!file1.exists()){
            file1.createNewFile();
        }else {
            file1.delete();
            file1.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }
}
