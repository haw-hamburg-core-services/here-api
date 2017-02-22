package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * Specify whether to optimize a route for traffic.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TrafficModeType {
    enabled("enabled"),
    disabled("disabled"),
    auto("default");

    private String name;

    TrafficModeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
