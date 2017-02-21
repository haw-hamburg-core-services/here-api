package de.haw_hamburg.informatik.core.here4j.routing.parameters;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class WaypointParameterTest {

    @Test
    public void toRequestStringTest() throws Exception {
        assertEquals("1 Failed!",new WaypointParameter(1.3,123.546).toRequestString(), "geo!1.3,123.546");
        assertEquals("2 Failed!",new WaypointParameter(1.3,123.546, 176.3).toRequestString(), "geo!1.3,123.546,176.3");

        assertEquals("3 Failed!",new WaypointParameter(1.3,123.546, 5).toRequestString(), "geo!1.3,123.546;5");
        assertEquals("4 Failed!",new WaypointParameter(1.3,123.546, "Home").toRequestString(), "geo!1.3,123.546;;Home");
        assertEquals("5 Failed!",new WaypointParameter(1.3,123.546, WaypointParameter.Type.passThrough).toRequestString(), "geo!passThrough!1.3,123.546");
        assertEquals("6 Failed!",new WaypointParameter(1.3,123.546, 176.3, 5).toRequestString(), "geo!1.3,123.546,176.3;5");
        assertEquals("7 Failed!",new WaypointParameter(1.3,123.546, 176.3, "Home").toRequestString(), "geo!1.3,123.546,176.3;;Home");
        assertEquals("8 Failed!",new WaypointParameter(1.3,123.546, 176.3, WaypointParameter.Type.passThrough).toRequestString(), "geo!passThrough!1.3,123.546,176.3");

        assertEquals("9 Failed!",new WaypointParameter(1.3,123.546, 176.3, "Home", WaypointParameter.Type.passThrough, 5).toRequestString(), "geo!passThrough!1.3,123.546,176.3;5;Home");

    }
}
