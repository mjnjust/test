package com.example.capture;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/13.
 */
public class Capture {
    public static String[] headers = new String[]{
            "Host","User-Agent","Accept","Accept-Language","Accept-Encoding",
            "Referer","Cookie","Connection","Pragma","Cache-Control"
    };
    public static void main(String[] args){
//        StringBuffer response = new StringBuffer();
//        String urlstring = "http://202.119.81.112:8080/Logon.do?method=logon";
//        try {
//            URL neturl = new URL(urlstring);
//            URLConnection urlConnection = neturl.openConnection();
//            urlConnection.setRequestProperty("Host","202.119.81.112:8080");
//            urlConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
//            urlConnection.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//            urlConnection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
////            urlConnection.setRequestProperty("Accept-Encoding","deflate");
//            urlConnection.setRequestProperty("Referer","http://202.119.81.112:8080/");
//            urlConnection.setRequestProperty("Cookie","JSESSIONID=7A3E2FA795CFE2B0F3541DB6DFED72E1");
//            urlConnection.setRequestProperty("Connection","keep-alive");
//            urlConnection.setRequestProperty("pragma","no-cache");
//            urlConnection.setRequestProperty("Cache-Control","no-cache");
//            urlConnection.connect();
//            Map<String,List<String>> map = urlConnection.getHeaderFields();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//            String string = null ;
//            while ((string = bufferedReader.readLine())!=null){
//                System.out.println(string);
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String url = "http://202.119.81.113:9080/njlgdx/xk/Verifyservlet";
        Map<String,String> header = new HashMap<String, String>() ;
        int index = 0 ;
        header.put(headers[index++],"202.119.81.108:8080");
        header.put(headers[index++],"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
        header.put(headers[index++],"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        header.put(headers[index++],"zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        header.put(headers[index++],"deflate");
        header.put(headers[index++],"http://202.119.81.108:8080/index.aspx");
        header.put(headers[index++],"JSESSIONID=55221C0C1D3BE2DD7FD56695572B7E10");
        header.put(headers[index++],"keep-alive");
        header.put(headers[index++],"no-cache");
        header.put(headers[index++],"no-cache");
        String params = "USERNAME=912106840335&PASSWORD=Zheng199497&RANDOMCODE=vcb2";
//        doPostRequest(url,header,params);
        doGetRequest(url,header,params);
    }
    public static void doGetRequest(String url,Map<String,String> header,String params){
        URLConnection urlConnection = null ;
        InputStream inputStream = null ;
        try {
            URL neturl = new URL(url+"?"+params);
            urlConnection = neturl.openConnection();
            for(int i=0;i<headers.length;i++){
                urlConnection.setRequestProperty(headers[i],header.get(headers[i]));
            }
            Map<String,List<String>> map = urlConnection.getHeaderFields();
            urlConnection.connect();
            inputStream = urlConnection.getInputStream() ;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String string = null ;
            while ((string = bufferedReader.readLine())!=null){
                System.out.println(string);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void doPostRequest(String url,Map<String,String> header,String params){
        URLConnection urlConnection = null ;
        OutputStream outputStream = null ;
        InputStream inputStream = null ;
        try {
            URL neturl = new URL(url);
            urlConnection = neturl.openConnection();
            for(int i=0;i<headers.length;i++){
                urlConnection.setRequestProperty(headers[i],header.get(headers[i]));
            }
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            outputStream = urlConnection.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write(params+"\n");
            printWriter.flush();
            Map<String,List<String>> map = urlConnection.getHeaderFields();
            inputStream = urlConnection.getInputStream() ;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String string = null ;
            while ((string = bufferedReader.readLine())!=null){
                System.out.println(string);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
