package de.haw_hamburg.informatik.core.here4j.weather;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

/**
 * Created by skrec on 10.01.2017.
 */
public class WeatherTest {

    Weather weather;

    @Before
    public void setUp() throws Exception {
        weather = new Weather();

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void requestReport() throws Exception {
        boolean success = false;
        try {
            String response = weather.requestReport("Hamburg", WeatherProduct.forecast_hourly);
            success = true;

        }catch (Exception e){
            e.printStackTrace();
        }

        assertTrue("No WeatherAPI access granted.", success);
    }

}