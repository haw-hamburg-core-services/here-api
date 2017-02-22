package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * A Route describes a distinct path through the navigable road network between two or more waypoints. It consists of
 * route legs, each of which is a path between two waypoints.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteType {

    /**
     * Permanent unique identifier of the route, generated based on route links. Can be used to reproduce any previously
     * calculated route.
     */
    private String routeId;

    /**
     * List of waypoints that have been defined when requesting for a route calculation. The first waypoint is defined
     * as the start of the route; the last waypoint marks the destination. Any points in between the two are considered
     * via points.
     */
    private WaypointType[] waypoint;

    /**
     * Settings for route calculation. One mode can be specified for each route.
     */
    private RoutingModeType mode;

    /**
     * Partition of the route into legs between the different waypoints.
     */
    private RouteLegType [] leg;

    /**
     * Overall route distance and time summary.
     */
    private RouteSummaryType summary;

    public RouteType(String routeId, WaypointType[] waypoint, RoutingModeType mode, RouteLegType [] leg, RouteSummaryType summary) {
        this.routeId = routeId;
        this.waypoint = waypoint;
        this.mode = mode;
        this.leg = leg;
        this.summary = summary;
    }

    public RouteType() {
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public WaypointType[] getWaypoint() {
        return waypoint;
    }

    public void setWaypoint(WaypointType[] waypoint) {
        this.waypoint = waypoint;
    }

    public RoutingModeType getMode() {
        return mode;
    }

    public void setMode(RoutingModeType mode) {
        this.mode = mode;
    }

    public RouteLegType [] getLeg() {
        return leg;
    }

    public void setLeg(RouteLegType [] leg) {
        this.leg = leg;
    }

    public RouteSummaryType getSummary() {
        return summary;
    }

    public void setSummary(RouteSummaryType summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "RouteType{" +
                "routeId='" + routeId + '\'' +
                ", waypoint=" + Arrays.toString(waypoint) +
                ", mode=" + mode +
                ", leg=" + Arrays.toString(leg) +
                ", summary=" + summary +
                '}';
    }
}
