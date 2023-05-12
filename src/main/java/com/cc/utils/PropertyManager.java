package com.cc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Manger class for the properties
 */
public class PropertyManager {
    private static Properties props = new Properties();
    LoggerManager utils = new LoggerManager();

    public Properties getProps() throws IOException {
        InputStream is = null;
        String propsFileName = "config.properties";

        if(props.isEmpty()){
            try{
                utils.log().info("loading config properties");
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Failed to load config properties" + e.toString());
                throw e;
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }
        return props;
    }
}
