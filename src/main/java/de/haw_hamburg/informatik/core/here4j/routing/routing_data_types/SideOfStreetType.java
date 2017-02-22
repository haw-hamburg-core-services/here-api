package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * Indicates whether the waypoint is on the left or right side of the link, when heading from the reference node to the non-reference node.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum SideOfStreetType {
    left,
    right,
    neither,
}
