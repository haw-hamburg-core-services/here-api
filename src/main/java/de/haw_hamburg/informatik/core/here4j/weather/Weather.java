package de.haw_hamburg.informatik.core.here4j.weather;

import de.haw_hamburg.informatik.core.here4j.PropertyReader;

import java.io.IOException;

/**
 * Created by skrec on 03.01.2017.
 */
public class Weather {
    private final static String BASE_URL = "https://weather.api.here.com";
    private final static String PATH = "/weather/1.0/";

    private final static String FORMAT_SPEC = ".json";

    private final static String APP_ID;
    private final static String APP_CODE;

    /**
     * name:
     *      latitude and longitude, name or zipcode must be present
     *
     *      Name of a city. If there is more than one match for the name,
     *      then the most populous location is in the response. Country,
     *      state and street name can be added to this parameter.
     *
     *      For example, the response for "name=Berlin, USA" is a report for
     *      the city of "Berlin, New Hampshire", the response for "name=Berlin,
     *      IL" is a report for the city of Berlin, Illinois, and the response
     *      for "name=Berlin" is a report for the city of Berlin, Germany.
     **/

    public Weather() {
        try {
            PropertyReader properties = new PropertyReader();
            APP_ID = "&app_id={" + properties.appID + "}";
            APP_CODE = "&app_code={" + properties.appCode + "}";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
