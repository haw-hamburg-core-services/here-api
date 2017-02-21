package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * RoutingTypeType provides identifiers for different optimizations which can be applied during the route calculation.
 * Selecting the routing type affects which constraints, speed attributes and weights are taken into account during
 * route calculation.
 */

public enum RoutingTypeType {
    fastest,
    shortest,
}

