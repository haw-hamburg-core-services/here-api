package de.haw_hamburg.informatik.core.here4j.routing.resources;

import de.haw_hamburg.informatik.core.here4j.routing.parameters.Area;
import de.haw_hamburg.informatik.core.here4j.base_data_types.LanguageCodeType;
import de.haw_hamburg.informatik.core.here4j.routing.response_data_types.CalculateRouteResponse;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.RoutingModeType;
import de.haw_hamburg.informatik.core.here4j.routing.parameters.Waypoint;
import javafx.util.Pair;

import java.net.URISyntaxException;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * Use the calculateroute resource to return a route between two waypoints.
 *
 * The required parameters for this resource are two or more waypoints (waypoint0 and waypoint1, to waypointN)
 * and mode (specifying how to calculate the route, and for what mode of transport).
 *
 * For some modes departure or arrival (if applicable) is required. This includes publicTransportTimeTable,
 * publicTransport and all modes with enabled traffic. Other parameters can be left unspecified.
 */
public class CalculateRoute extends RouteRequest {

    private Waypoint [] waypoints = null;
    private RoutingModeType mode = null;
    private String requestId = null;
    private List<Area> avoidAreas = null;
    private Pair<String, Date> timeDate = null;
    private int alternatives = 0;
    private LanguageCodeType language = null;

    /**
     * Create a CalculationIsolineRequest object to resources a calculationisoline from here api.
     *
     * @param waypoints    Required!   list of waypoints to calculate isoline for.
     * @param mode         Required!   specify how to calculate the route
     * @param requestId    Optional -> may be null
     * @param avoidAreas   Optional -> may be null
     * @param timeDate     Optional -> may be null
     * @param alternatives Optional -> may be null
     * @param language     Optional -> may be null
     */
    public CalculateRoute(Waypoint [] waypoints, RoutingModeType mode, String requestId, List<Area> avoidAreas, Pair<String, Date> timeDate, int alternatives, LanguageCodeType language) throws InvalidParameterException {
        super(Resource.calculateroute);
        if(waypoints == null){
            throw new InvalidParameterException("No waypoints specified, at least 2 required.");
        }else if(mode == null){
            throw new InvalidParameterException("No mode specified, but required.");
        }

        this.waypoints = waypoints;
        this.mode = mode;
        this.requestId = requestId;
        this.avoidAreas = avoidAreas;
        this.timeDate = timeDate;
        this.alternatives = alternatives;
        this.language = language;
    }

    public CalculateRouteResponse request() throws URISyntaxException {
        Map<String, String> params = new HashMap<>();

        //fill map for parameters according to object variables.
        //waypoints
        int counter = 0;
        for (Waypoint waypoint : waypoints) {
            params.put("waypoint" + counter++, waypoint.toRequestString());
        }

        //mode
        if (mode != null) {
            params.put("mode", mode.toRequestString());
        }

        //requestId
        if (requestId != null) {
            params.put("requestId", requestId);
        }

        //avoidAreas
        if (avoidAreas != null) {
            String avoidAreasString = null;
            for (Area area : avoidAreas) {
                if (avoidAreasString != null) {
                    avoidAreasString += "!" + area.toRequestString();
                } else {
                    avoidAreasString = area.toRequestString();
                }
            }
            params.put("avoidAreas", avoidAreasString);
        }

        //requestId
        if (timeDate != null) {
            params.put(timeDate.getKey(), timeDate.getValue().toString());
        }

        //alternatives
        if (alternatives != 0) {
            params.put("alternatives", String.valueOf(alternatives));
        }

        //language
        if (language != null) {
            params.put("language", language.getCode());
        }

        //execute resources!
        return request(params, CalculateRouteResponse.class);
    }
}
