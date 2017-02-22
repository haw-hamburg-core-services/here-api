package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * The service defines a route leg as the portion of a route between one waypoint and the next. RouteLegType contains
 * information about a route leg, such as the time required to traverse it, its shape, start and end point, as well as
 * information about any sublegs contained in the leg due to the presence of passthrough waypoints.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteLegType {

    /**
     * Route waypoint that is located at the start of this route leg. This waypoint matches one of the waypoints in the
     * Route.
     */
    private WaypointType start;

    /**
     * Route waypoint that is located at the end of this route leg. This waypoint matches one of the waypoints in the
     * Route.
     */
    private WaypointType end;

    /**
     * Length of the leg.
     */
    private double length;

    /**
     * The time in seconds needed to travel along this route leg. Considers any available traffic information, if
     * enabled and the authorized for the user.
     */
    private double travelTime;

    /**
     * List of all maneuvers which are included in this portion of the route.
     */
    private ManeuverType [] maneuver;

    public RouteLegType(WaypointType start, WaypointType end, double length, double travelTime, ManeuverType [] maneuver) {
        this.start = start;
        this.end = end;
        this.length = length;
        this.travelTime = travelTime;
        this.maneuver = maneuver;
    }

    public RouteLegType() {
    }

    public WaypointType getStart() {
        return start;
    }

    public void setStart(WaypointType start) {
        this.start = start;
    }

    public WaypointType getEnd() {
        return end;
    }

    public void setEnd(WaypointType end) {
        this.end = end;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public ManeuverType [] getManeuver() {
        return maneuver;
    }

    public void setManeuver(ManeuverType [] maneuver) {
        this.maneuver = maneuver;
    }

    @Override
    public String toString() {
        return "RouteLegType{" +
                "start=" + start +
                ", end=" + end +
                ", length=" + length +
                ", travelTime=" + travelTime +
                ", maneuver=" + Arrays.toString(maneuver) +
                '}';
    }
}
