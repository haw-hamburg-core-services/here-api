package de.haw_hamburg.informatik.core.here4j.routing;

import org.junit.Test;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class SimpleRouteTest {

    @Test
    public void testRequest() throws Exception {
        String response = new SimpleRouteRequest().request();

        System.out.println(response);
    }
}
