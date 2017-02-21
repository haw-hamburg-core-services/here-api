package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * Route feature weights are used to define weighted conditions on special route features like tollroad, motorways, etc.
 */
public enum RouteFeatureWeight {
    strictExclude(-3),
    softExclude(-2),
    avoid(-1),
    normal(0),;

    private int value;

    RouteFeatureWeight(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

