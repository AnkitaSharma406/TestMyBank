package com.TestMyBank.utilities;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.File;


public class ReadConfig {
    Properties pro;

    public ReadConfig(){
        File src= new File("C:\\Users\\406an\\IdeaProjects\\TestMyBank\\Configurations\\config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch(Exception e){
            System.out.println("Exception is"+e.getMessage());
        }
    }

    public String getApplicationURL(){
       return pro.getProperty("baseUrl");
    }

    public String getUsername(){
        return pro.getProperty("username");
    }
    public String getPassword(){
        return pro.getProperty("password");
    }






}
