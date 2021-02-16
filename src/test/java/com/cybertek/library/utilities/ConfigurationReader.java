package com.cybertek.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

   private static Properties properties=new Properties();

    static {
        try (FileInputStream inputStream = new FileInputStream("config.properties")) {
            properties.load(inputStream);
            inputStream.close();
        }catch (IOException e){
            e.getStackTrace();
        }
    }
    public static String getProperty(String key){
       return properties.getProperty(key);
    }
}
