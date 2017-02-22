package de.haw_hamburg.informatik.core.here4j.geocoder.resources;

import de.haw_hamburg.informatik.core.here4j.query.ARequest;
import de.haw_hamburg.informatik.core.here4j.query.ResponseFormat;
import sun.reflect.generics.tree.FormalTypeParameter;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TimoHäckel on 22.02.2017.
 */
public class Geocoding extends ARequest{

    /**
     * Query defines.
     */
    private static final String BASEURL = "https://geocoder.api.here.com";
    private static final String PATH = "/6.2/";
    private static final String RESOURCE = "geocode";

    private static final int gen = 9; //current API generation for compatibility.

    private String searchtext = null;


    public Geocoding(String searchtext) {
        super(BASEURL, PATH, RESOURCE, ResponseFormat.json);
        searchtext = searchtext.replace(" ", "+");
        this.searchtext = searchtext;
    }

    public <T> T request (Class<T> responseType) throws URISyntaxException {

        Map<String, String> params = new HashMap<>();

        params.put("gen", String.valueOf(gen));

        if(searchtext != null){
            params.put("searchtext", searchtext);
        }

        return request(params, responseType);
    }
}
