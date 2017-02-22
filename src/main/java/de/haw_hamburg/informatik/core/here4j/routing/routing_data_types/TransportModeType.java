package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * Specify which mode of transport to calculate the route for.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TransportModeType {
    car,
    carHOV,
    pedestrian,
    publicTransport,
    publicTransportTimeTable,
    truck,
    bicycle,
}
