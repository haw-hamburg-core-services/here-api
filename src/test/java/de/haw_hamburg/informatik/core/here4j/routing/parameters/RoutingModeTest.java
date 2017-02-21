package de.haw_hamburg.informatik.core.here4j.routing.parameters;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class RoutingModeTest {

    @Test
    public void toRequestStringTest() throws Exception {
        Map<RoutingMode.RouteFeature, RoutingMode.RouteFeatureWeight> features = new HashMap<>();
        features.put(RoutingMode.RouteFeature.motorway, RoutingMode.RouteFeatureWeight.softExclude);

        assertEquals("1 Failed!", new RoutingMode(RoutingMode.RoutingType.fastest).toRequestString(), "fastest");
        assertEquals("1 Failed!", new RoutingMode(RoutingMode.RoutingType.fastest, RoutingMode.TransportMode.car).toRequestString(), "fastest;car");
        assertEquals("1 Failed!", new RoutingMode(RoutingMode.RoutingType.fastest, RoutingMode.TrafficMode.disabled).toRequestString(), "fastest;traffic:disabled");
        assertEquals("1 Failed!", new RoutingMode(RoutingMode.RoutingType.fastest, features).toRequestString(), "fastest;motorway:-2");
        assertEquals("1 Failed!", new RoutingMode(RoutingMode.RoutingType.fastest, RoutingMode.TransportMode.car, RoutingMode.TrafficMode.disabled).toRequestString(), "fastest;car;traffic:disabled");
        assertEquals("1 Failed!", new RoutingMode(RoutingMode.RoutingType.fastest, RoutingMode.TransportMode.car, features).toRequestString(), "fastest;car;motorway:-2");
        assertEquals("1 Failed!", new RoutingMode(RoutingMode.RoutingType.fastest, RoutingMode.TrafficMode.disabled, features).toRequestString(), "fastest;traffic:disabled;motorway:-2");
        assertEquals("1 Failed!", new RoutingMode(RoutingMode.RoutingType.fastest, RoutingMode.TransportMode.car, RoutingMode.TrafficMode.disabled, features).toRequestString(), "fastest;car;traffic:disabled;motorway:-2");

    }
}
