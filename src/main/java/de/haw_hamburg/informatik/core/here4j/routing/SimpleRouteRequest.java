package de.haw_hamburg.informatik.core.here4j.routing;

import de.haw_hamburg.informatik.core.here4j.ARequest;
import de.haw_hamburg.informatik.core.here4j.Properties;
import de.haw_hamburg.informatik.core.here4j.PropertyReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class SimpleRouteRequest extends ARequest{

    private Logger logger = LoggerFactory.getLogger(SimpleRouteRequest.class);


    private final static String BASEURL = "https://route.cit.api.here.com";
    private final static String PATH = "/routing/7.2/";
    private final static String RESOURCE = "calculateroute";
    private final static String FORMAT = "json";


    private final static String mode = "fastest;car;traffic:disabled";

    private final static String waypoint0Default = "geo!52.5,13.4";
    private String waypoint0;
    private final static String waypoint1Default = "geo!52.5,13.45";
    private String waypoint1;

    public SimpleRouteRequest() {
        this(waypoint0Default, waypoint1Default);
    }

    public SimpleRouteRequest(String waypoint0, String waypoint1) {
        super(BASEURL, PATH, RESOURCE, FORMAT);
        this.waypoint0 = waypoint0;
        this.waypoint1 = waypoint1;
    }

    public String request () throws URISyntaxException {

        Map<String,String> params = new HashMap<>();

        params.put("waypoint0", waypoint0);
        params.put("waypoint1", waypoint1);
        params.put("mode", mode);

        return request(params,String.class);
    }
}
