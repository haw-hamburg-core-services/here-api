package de.haw_hamburg.informatik.core.here4j.routing.parameters;

import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.RoutingModeType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class RoutingModeTypeTest {

    @Test
    public void toRequestStringTest() throws Exception {
        Map<RoutingModeType.RouteFeature, RoutingModeType.RouteFeatureWeight> features = new HashMap<>();
        features.put(RoutingModeType.RouteFeature.motorway, RoutingModeType.RouteFeatureWeight.softExclude);

        assertEquals("1 Failed!", new RoutingModeType(RoutingModeType.RoutingType.fastest).toRequestString(), "fastest");
        assertEquals("1 Failed!", new RoutingModeType(RoutingModeType.RoutingType.fastest, RoutingModeType.TransportMode.car).toRequestString(), "fastest;car");
        assertEquals("1 Failed!", new RoutingModeType(RoutingModeType.RoutingType.fastest, RoutingModeType.TrafficMode.disabled).toRequestString(), "fastest;traffic:disabled");
        assertEquals("1 Failed!", new RoutingModeType(RoutingModeType.RoutingType.fastest, features).toRequestString(), "fastest;motorway:-2");
        assertEquals("1 Failed!", new RoutingModeType(RoutingModeType.RoutingType.fastest, RoutingModeType.TransportMode.car, RoutingModeType.TrafficMode.disabled).toRequestString(), "fastest;car;traffic:disabled");
        assertEquals("1 Failed!", new RoutingModeType(RoutingModeType.RoutingType.fastest, RoutingModeType.TransportMode.car, features).toRequestString(), "fastest;car;motorway:-2");
        assertEquals("1 Failed!", new RoutingModeType(RoutingModeType.RoutingType.fastest, RoutingModeType.TrafficMode.disabled, features).toRequestString(), "fastest;traffic:disabled;motorway:-2");
        assertEquals("1 Failed!", new RoutingModeType(RoutingModeType.RoutingType.fastest, RoutingModeType.TransportMode.car, RoutingModeType.TrafficMode.disabled, features).toRequestString(), "fastest;car;traffic:disabled;motorway:-2");

    }
}
