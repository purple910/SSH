package com.example.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class file extends ActionSupport {

    /**
     * 上传的文件
     */
    private File file;
    /**
     * 上传的文件名字
     */
    private String fileFileName;
    /**
     * 上传文件的属性
     */
    private String fileContentType;


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String upload() throws Exception{
        System.out.println(UUID.randomUUID());
        System.out.println(file);
        System.out.println(fileFileName);
        System.out.println(fileContentType);

        InputStream input = new FileInputStream(file);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy\\MM\\dd");

//        File serverFile = new File("E:\\2019\\09\\14"+fileFileName);
        //创建空文件夹
        File filePath = new File("E:\\20180\\Documents\\"+format.format(date));
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        File serverFile = new File(filePath,UUID.randomUUID().toString());
        //判断文件是否已存在
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        OutputStream out = new FileOutputStream(serverFile);


        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = input.read(bytes)) > -1){
//            out.write(bytes);
            out.write(bytes,0,len);
        }


        out.close();
        input.close();

        return SUCCESS;
    }



}
