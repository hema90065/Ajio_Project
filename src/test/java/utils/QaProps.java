package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class QaProps {
    //src/test/resources/env1.properties
    private  static Properties properties;
    // private constructor + static methods for object creation with if block -> singleton design pattern

    private QaProps(){

    }
    public static void  init(){
        if(properties==null){
            properties = new Properties();
            try {
                properties.load(new FileInputStream("src/test/resources/env.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static String  getValue(String key){
        init();
        return properties.getProperty(key);
    }
}
