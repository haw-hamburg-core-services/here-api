package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * This type provides summary information for the entire route. This type of information includes travel time, distance,
 * and descriptions of the overall route path.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteSummaryType {

    /**
     * Indicates total travel distance for the route, in meters.
     */
    private double distance;

    /**
     * Contains the travel time estimate in seconds for this element, considering traffic and transport mode. Based on
     * the TrafficSpeed. The service may also account for additional time penalties, so this may be greater than the
     * element length divided by the TrafficSpeed.
     */
    private double trafficTime;

    /**
     * Contains the travel time estimate in seconds for this element, considering transport mode but not traffic
     * conditions. Based on the BaseSpeed. The service may also account for additional time penalties, therefore this
     * may be greater than the element length divided by the BaseSpeed.
     */
    private double baseTime;

    /**
     * Special link characteristics (like ferry or motorway usage) which are covered by the route.
     */
    private RouteLinkFlagType [] flags;

    /**
     * Textual description of route summary.
     */
    private String text;

    /**
     * Total travel time in seconds optionally considering traffic depending on the request parameters.
     */
    private double travelTime;

    /**
     * Type of the route.
     */
    private String _type;

    public RouteSummaryType(double distance, double trafficTime, double baseTime, RouteLinkFlagType [] flags, String text, double travelTime, String _type) {
        this.distance = distance;
        this.trafficTime = trafficTime;
        this.baseTime = baseTime;
        this.flags = flags;
        this.text = text;
        this.travelTime = travelTime;
        this._type = _type;
    }

    public RouteSummaryType() {
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTrafficTime() {
        return trafficTime;
    }

    public void setTrafficTime(double trafficTime) {
        this.trafficTime = trafficTime;
    }

    public double getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(double baseTime) {
        this.baseTime = baseTime;
    }

    public RouteLinkFlagType [] getFlags() {
        return flags;
    }

    public void setFlags(RouteLinkFlagType [] flags) {
        this.flags = flags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    @Override
    public String toString() {
        return "RouteSummaryType{" +
                "distance=" + distance +
                ", trafficTime=" + trafficTime +
                ", baseTime=" + baseTime +
                ", flags=" + Arrays.toString(flags) +
                ", text='" + text + '\'' +
                ", travelTime=" + travelTime +
                ", _type='" + _type + '\'' +
                '}';
    }
}
