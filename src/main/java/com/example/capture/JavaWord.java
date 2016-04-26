package com.example.capture;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;

/**
 * Created by Administrator on 2016/4/15.
 */
public class JavaWord {
    public static void main(String[] args){
        String filename = "C:\\Users\\Administrator\\Desktop\\test.docx" ;
        String writeword = "C:\\Users\\Administrator\\Desktop\\write.docx" ;
        try {
            OPCPackage opcPackage = POIXMLDocument.openPackage(filename);
            XWPFDocument xwpfDocument = new XWPFDocument(opcPackage);
            XWPFParagraph xmlParagraph = xwpfDocument.getParagraphs().get(0);
            XWPFRun xwpfRun = xmlParagraph.insertNewRun(0);
            xwpfRun.setText("hello!");
            FileOutputStream fileOutputStream = new FileOutputStream(writeword);
            xwpfDocument.write(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String filename = "C:\\Users\\Administrator\\Desktop\\test.txt" ;
//        File file = new File(filename);
//        if(file.exists()){
//            file.delete();
//        }
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
//            outputStreamWriter.write("hello"+"\n");
//            outputStreamWriter.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
