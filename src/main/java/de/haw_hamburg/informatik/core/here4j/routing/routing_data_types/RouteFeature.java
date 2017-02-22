package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * The routing features can be used to define special conditions on the calculated route.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum RouteFeature {
    tollroad,
    motorway,
    boatFerry,
    railFerry,
    tunnel,
    dirtRoad,
    park,
}
