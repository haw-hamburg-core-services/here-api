package de.haw_hamburg.informatik.core.here4j;

import de.haw_hamburg.informatik.core.here4j.weather.Product;
import de.haw_hamburg.informatik.core.here4j.weather.Weather;

import java.io.IOException;

/**
 * Created by skrec on 03.01.2017.
 */
public class Application {
    public static void main (String ... args ){
        Weather weather = new Weather();
        String response = weather.requestReport("Hamburg", Product.forecast_hourly);

        System.out.println(response);
    }
}
