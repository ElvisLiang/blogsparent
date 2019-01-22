package com.blogs.auth.utils;

import com.blogs.user.entity.User;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.LinkedHashMap;

public class ConvertUtils {

    @Value("${headpictureurl}")
    private String headPictureUrl;

    public static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 头像二进制转图片格式
     * @return
     */
    public  String  blobConvertPicture(byte[] blob,String name){
        File file = new File("F:/head/"+name+".jpg");
        FileInputStream in = null;
        try{
            if(!file.exists()){
                file.createNewFile();
            }
             in = new FileInputStream(file);
            byte[] bytes = new byte[blob.length];
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(in.read(bytes));
        }catch(IOException e){
            e.printStackTrace();
        }
        return "";
    }
}
