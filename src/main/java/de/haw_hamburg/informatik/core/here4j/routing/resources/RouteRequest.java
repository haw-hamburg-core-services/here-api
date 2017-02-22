package de.haw_hamburg.informatik.core.here4j.routing.resources;

import de.haw_hamburg.informatik.core.here4j.query.ARequest;
import de.haw_hamburg.informatik.core.here4j.query.ResponseFormat;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.RoutingModeType;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.RoutingTypeType;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.TransportModeType;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class RouteRequest extends ARequest{

    private final static String BASEURL = "https://route.api.here.com";
    private final static String PATH = "/routing/7.2/";
    private static final ResponseFormat RESPONSE_FORMAT = ResponseFormat.json;


    public enum Resource {
        calculateroute,
        getroute,
        calculateisoline,
        calculatematrix,
    }

    public RouteRequest() {
        this(Resource.calculateroute);
    }

    public RouteRequest(Resource resource) {
        super(BASEURL, PATH, resource.name(), RESPONSE_FORMAT);
    }

    public String request (String waypoint0, String waypoint1, RoutingModeType routingMode) throws URISyntaxException {

        Map<String,String> params = new HashMap<>();

        params.put("waypoint0", waypoint0);
        params.put("waypoint1", waypoint1);
        params.put("mode", routingMode.toRequestString());

        return request(params,String.class);
    }

    public String request (String waypoint0, String waypoint1) throws URISyntaxException {

        TransportModeType [] transportModeTypes = new TransportModeType [1];
        transportModeTypes[0] =  TransportModeType.car;
        return request(waypoint0, waypoint1, new RoutingModeType(RoutingTypeType.fastest, transportModeTypes));
    }


}
