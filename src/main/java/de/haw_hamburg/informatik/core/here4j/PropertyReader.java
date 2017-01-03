package de.haw_hamburg.informatik.core.here4j;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by skrec on 03.01.2017.
 * This class will read the Property file from the resource path into the program and provide it to the here api.
 */
public class PropertyReader {

    public final String appID;
    public final String appCode;

    public PropertyReader(String filePath) throws IOException {
        File configFile = new File(getClass().getClassLoader().getResource(filePath).getFile());
        FileReader reader = new FileReader(configFile);
        Properties props = new Properties();
        props.load(reader);

        appID = props.getProperty("appid");
        appCode = props.getProperty("appcode");

        reader.close();
    }

    public PropertyReader() throws IOException {
        this("here4j.properties");
    }
}
