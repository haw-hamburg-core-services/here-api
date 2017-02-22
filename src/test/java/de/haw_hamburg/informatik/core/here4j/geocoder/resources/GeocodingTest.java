package de.haw_hamburg.informatik.core.here4j.geocoder.resources;

import de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types.GeocodingResponse;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by TimoHäckel on 22.02.2017.
 */
public class GeocodingTest {
    @Test
    public void requestTest() throws Exception {
        Geocoding geocoding = new Geocoding("Sassenburger Weg 10c, 22147 Hamburg, Germany");

        String responseString = geocoding.request(String.class);
        System.out.println(responseString);

        GeocodingResponse response = geocoding.request(GeocodingResponse.class);
        System.out.println(response);
    }

}