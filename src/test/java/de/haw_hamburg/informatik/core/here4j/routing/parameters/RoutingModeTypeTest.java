package de.haw_hamburg.informatik.core.here4j.routing.parameters;

import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class RoutingModeTypeTest {

    @Test
    public void toRequestStringTest() throws Exception {
        String [] features = new String [1];
        TransportModeType [] transportModeTypes = new TransportModeType [1];
        transportModeTypes[0] = TransportModeType.car;
        features [0] = RouteFeature.motorway.name() + ":" + RouteFeatureWeight.softExclude.getValue();
        assertEquals("1 Failed!", new RoutingModeType(RoutingTypeType.fastest).toRequestString(), "fastest");
        assertEquals("2 Failed!", new RoutingModeType(RoutingTypeType.fastest, transportModeTypes).toRequestString(), "fastest;car");
        assertEquals("3 Failed!", new RoutingModeType(RoutingTypeType.fastest, TrafficModeType.disabled).toRequestString(), "fastest;traffic:disabled");
        assertEquals("4 Failed!", new RoutingModeType(RoutingTypeType.fastest, features).toRequestString(), "fastest;motorway:-2");
        assertEquals("5 Failed!", new RoutingModeType(RoutingTypeType.fastest, transportModeTypes, TrafficModeType.disabled).toRequestString(), "fastest;car;traffic:disabled");
        assertEquals("6 Failed!", new RoutingModeType(RoutingTypeType.fastest, transportModeTypes, features).toRequestString(), "fastest;car;motorway:-2");
        assertEquals("7 Failed!", new RoutingModeType(RoutingTypeType.fastest, TrafficModeType.disabled, features).toRequestString(), "fastest;traffic:disabled;motorway:-2");
        assertEquals("8 Failed!", new RoutingModeType(RoutingTypeType.fastest, transportModeTypes, TrafficModeType.disabled, features).toRequestString(), "fastest;car;traffic:disabled;motorway:-2");

    }
}
