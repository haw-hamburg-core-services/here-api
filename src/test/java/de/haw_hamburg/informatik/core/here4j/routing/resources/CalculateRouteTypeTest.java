package de.haw_hamburg.informatik.core.here4j.routing.resources;

import de.haw_hamburg.informatik.core.here4j.base_data_types.LanguageCodeType;
import de.haw_hamburg.informatik.core.here4j.routing.response_data_types.CalculateRouteResponse;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.RoutingModeType;
import de.haw_hamburg.informatik.core.here4j.routing.parameters.Waypoint;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.RoutingTypeType;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.TransportModeType;
import org.junit.Test;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class CalculateRouteTypeTest {
    @Test
    public void requestTest() throws Exception {

        Waypoint [] waypoints = new Waypoint [2];
        waypoints[0] = new Waypoint(52.5,13.4);
        waypoints[1] = new Waypoint(52.5,13.45);
        TransportModeType [] transportModeTypes = new TransportModeType [1];
        transportModeTypes[0] = TransportModeType.car;
        CalculateRoute request = new CalculateRoute(waypoints, new RoutingModeType(RoutingTypeType.fastest, transportModeTypes),"lulu1",null,null, 2, new LanguageCodeType("de-de"));

        CalculateRouteResponse routeResponse = request.request();
        System.out.println(routeResponse);

    }
}
