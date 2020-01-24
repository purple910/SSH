package com.example.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**

/**
 * @program: struts-02 com.example.action
 *
 * @description:
 *
 * @author: fate
 *
 * @create: 2019-09-14 17:01
 **/
public class downAction extends ActionSupport {

    private String id;
    private String fileName;

    @Override
    public String execute() throws Exception{

        return SUCCESS;
    }

    public InputStream getDownloadFile(){
        this.id = "1";
        File serverFile = new File("E:\\20180\\Pictures\\Saved Pictures\\1.jpg");
        this.fileName="1.jpg";
        System.out.println(serverFile);
        InputStream input = null;
        try {
            input = new FileInputStream(serverFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
