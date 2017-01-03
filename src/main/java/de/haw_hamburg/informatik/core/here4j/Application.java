package de.haw_hamburg.informatik.core.here4j;

import java.io.IOException;

/**
 * Created by skrec on 03.01.2017.
 */
public class Application {
    public static void main (String ... args ){
        try {
            PropertyReader propertyReader = new PropertyReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
