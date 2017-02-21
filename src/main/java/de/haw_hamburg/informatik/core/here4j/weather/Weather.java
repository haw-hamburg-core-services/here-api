package de.haw_hamburg.informatik.core.here4j.weather;

import de.haw_hamburg.informatik.core.here4j.properties.Properties;
import de.haw_hamburg.informatik.core.here4j.properties.PropertyReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by skrec on 03.01.2017.
 */
public class Weather {
    private static final Logger log = LoggerFactory.getLogger(Weather.class);

    private final static String BASE_URL = "https://weather.api.here.com";
    private final static String PATH = "/weather/1.0/";

    private final static String FORMAT_SPEC = ".json";

    private Properties properties;

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

        Properties properties = PropertyReader.readProperties();
        if(properties != null) {
            this.properties = properties;
        } else {
            log.error("No properties could be found.");
        }

    }

    public String requestReport(String name, Product product){
        String response = null;
        String httpCall = BASE_URL + PATH + "report" + FORMAT_SPEC
                + "?app_id=" + properties.appID
                + "&app_code=" + properties.appCode
                + "&product=" + product.name()
                + "&name=" + name;
        System.out.println(httpCall);
        try {
            URI uri = new URI(httpCall);
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.getForObject(uri, String.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return response;
    }
}
