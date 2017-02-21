package de.haw_hamburg.informatik.core.here4j.routing.resources;

import de.haw_hamburg.informatik.core.here4j.query.ResponseFormat;
import de.haw_hamburg.informatik.core.here4j.routing.resources.RouteRequest;

import java.net.URISyntaxException;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class SimpleRouteRequest extends RouteRequest {

    private final static String BASEURL = "https://route.cit.api.here.com";
    private final static String PATH = "/routing/7.2/";
    private final static String RESOURCE = "calculateroute";
    private final static ResponseFormat FORMAT = ResponseFormat.json;


    private final static String mode = "fastest;car;traffic:disabled";

    private final static String waypoint0Default = "geo!52.5,13.4";
    private final static String waypoint1Default = "geo!52.5,13.45";

    public SimpleRouteRequest() {
        super(Resource.calculateroute);
    }

    public String request () throws URISyntaxException {
        return request(waypoint0Default, waypoint1Default);
    }

    public String request (String waypoint0, String waypoint1) throws URISyntaxException {

        return super.request(waypoint0,waypoint1);
    }
}
