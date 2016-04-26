package com.example.capture;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/4/13.
 */
public class LoginOurSchool {
    public static void main(String[] args){
        String sessionid = getFirstCookie("http://202.119.81.113:9080/njlgdx/");
        getRandomCode(sessionid,"http://202.119.81.113:9080/njlgdx/verifycode.servlet");
        String randomcode = new Scanner(System.in).next();
        String url = "http://202.119.81.113:9080/njlgdx/xk/Verifyservlet?USERNAME=912106840335&PASSWORD=Zheng199497&RANDOMCODE="+randomcode ;
        loginbyget(sessionid,url);
    }
    public static String getFirstCookie(String firsthtml){
        URLConnection urlConnection = null ;
        String ans = null ;
        try {
            URL loginrul = new URL(firsthtml);
            urlConnection = loginrul.openConnection();
            Map<String,List<String>> map = urlConnection.getHeaderFields() ;
            List<String> cookie = map.get("Set-Cookie");
            for (int i=0;i<cookie.size();i++){
                if(cookie.get(i).contains("JSESSIONID")){
                    String t = cookie.get(i);
                    System.out.println(t);
                    ans = t.substring(t.indexOf("=")+1,t.indexOf(";"));
                    break;
                }
            }
            System.out.println(ans);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
        return ans ;
    }
    public static void getRandomCode(String sessionid,String url){
        URLConnection urlConnection = null ;
        InputStream inputStream = null ;
        try {
            URL randomrul = new URL(url);
            urlConnection = randomrul.openConnection();
            initurl(urlConnection);
            urlConnection.setRequestProperty("Cookie","JSESSIONID="+sessionid);
            Map<String,List<String>> map = urlConnection.getHeaderFields() ;
//            Map<String,List<String>> xxx = urlConnection.getRequestProperties();
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            File file = new File("C:\\Users\\Administrator\\Desktop\\test.jpg");
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initurl(URLConnection urlConnection) {
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
        urlConnection.setRequestProperty("Accept", "image/png,image/*;q=0.8,*/*;q=0.5");
        urlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        urlConnection.setRequestProperty("Accept-Encoding", "deflate");
        urlConnection.setRequestProperty("Connection", "keep-alive");
        urlConnection.setRequestProperty("pragma", "no-cache");
        urlConnection.setRequestProperty("Catch-Control", "no-cache");
    }
    public static void loginbyget(String sessionid,String url){
        URLConnection urlConnection = null ;
        InputStream inputStream = null ;
        try {
            URL loginurl = new URL(url);
            urlConnection = loginurl.openConnection();
            initurl(urlConnection);
            urlConnection.setRequestProperty("Cookie","JSESSIONID="+sessionid);
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            String string = null ;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((string = bufferedReader.readLine())!=null){
                System.out.println(string);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}