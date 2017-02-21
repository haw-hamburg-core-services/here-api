package de.haw_hamburg.informatik.core.here4j.routing.resources;

import de.haw_hamburg.informatik.core.here4j.routing.base_data_types.LanguageCodeType;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.RoutingModeType;
import de.haw_hamburg.informatik.core.here4j.routing.parameters.Waypoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class CalculateRouteTypeTest {
    @Test
    public void requestTest() throws Exception {

        List<Waypoint> waypoints = new ArrayList<>();
        waypoints.add(new Waypoint(52.5,13.4));
        waypoints.add(new Waypoint(52.5,13.45));
        CalculateRoute request = new CalculateRoute(waypoints, new RoutingModeType(RoutingModeType.RoutingType.fastest, RoutingModeType.TransportMode.car),"lulu1",null,null, 2, LanguageCodeType.german_ger);

        String response = request.request(String.class);
        System.out.println(response);

//        request = new CalculateRoute(waypoints, null,null,null,null, 0, null);
//
//        response = request.request(String.class);
//        System.out.println(response);

    }
}
