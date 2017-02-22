package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * Defines a list of special characteristics that may apply to a link.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum RouteLinkFlagType {
    boatFerry,
    HOVLane,
    dirtRoad,
    motorway,
    noThroughRoad,
    park,
    railFerry,
    privateRoad,
    tollroad,
    tunnel,
    builtUpArea,
}
