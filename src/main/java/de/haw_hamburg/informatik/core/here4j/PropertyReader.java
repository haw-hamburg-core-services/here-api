package de.haw_hamburg.informatik.core.here4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by skrec on 03.01.2017.
 * This class will read the Properties file from the resource path into the program and provide it to the here api.
 */
public class PropertyReader {
    private static final Logger log = LoggerFactory.getLogger(PropertyReader.class);
    public static Properties readProperties(String propFileName) {
        Properties properties = null;
        try {
            java.util.Properties prop = new java.util.Properties();
            ClassLoader loader = PropertyReader.class.getClassLoader();
            InputStream inputStream = loader.getResourceAsStream(propFileName);

            if(inputStream != null){
                prop.load(inputStream);
                log.info(prop.toString());

                // get the property value and print it out
                String appid = prop.getProperty("appid");
                String appcode = prop.getProperty("appcode");

                properties = new Properties(appid, appcode);
            } else {
                log.error("No property file could be found.");
            }


            inputStream.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        return properties;
    }

    public static Properties readProperties() {
        return readProperties("here4j.properties");
    }
}
