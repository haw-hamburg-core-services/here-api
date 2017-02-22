package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * Defines the type of the waypoint, either stopOver or passThrough.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum WaypointParameterTypeType {
    stopOver,
    passThrough,
}