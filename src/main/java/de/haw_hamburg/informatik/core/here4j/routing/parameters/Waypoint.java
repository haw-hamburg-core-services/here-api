package de.haw_hamburg.informatik.core.here4j.routing.parameters;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.WaypointParameterTypeType;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Waypoint {

    private final static String PREFIX = "geo!";

    private double latitude;
    private double longitude;
    private Double altitude = Double.NaN;
    private String userLabel = null;
    private WaypointParameterTypeType type = null;
    private int transitRadius = 0;

    public Waypoint(double latitude, double longitude, double altitude, String userLabel, WaypointParameterTypeType type, int transitRadius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.userLabel = userLabel;
        this.type = type;
        this.transitRadius = transitRadius;
    }

    public Waypoint(double latitude, double longitude, double altitude, String userLabel, WaypointParameterTypeType type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.userLabel = userLabel;
        this.type = type;
    }

    public Waypoint(double latitude, double longitude, double altitude, WaypointParameterTypeType type, int transitRadius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.type = type;
        this.transitRadius = transitRadius;
    }

    public Waypoint(double latitude, double longitude, double altitude, WaypointParameterTypeType type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.type = type;
    }

    public Waypoint(double latitude, double longitude, double altitude, String userLabel, int transitRadius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.userLabel = userLabel;
        this.transitRadius = transitRadius;
    }

    public Waypoint(double latitude, double longitude, double altitude, String userLabel) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.userLabel = userLabel;
    }

    public Waypoint(double latitude, double longitude, double altitude, int transitRadius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.transitRadius = transitRadius;
    }

    public Waypoint(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public Waypoint(double latitude, double longitude, String userLabel, WaypointParameterTypeType type, int transitRadius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.userLabel = userLabel;
        this.type = type;
        this.transitRadius = transitRadius;
    }

    public Waypoint(double latitude, double longitude, String userLabel, WaypointParameterTypeType type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.userLabel = userLabel;
        this.type = type;
    }

    public Waypoint(double latitude, double longitude, WaypointParameterTypeType type, int transitRadius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.transitRadius = transitRadius;
    }

    public Waypoint(double latitude, double longitude, WaypointParameterTypeType type) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
    }

    public Waypoint(double latitude, double longitude, String userLabel, int transitRadius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.userLabel = userLabel;
        this.transitRadius = transitRadius;
    }

    public Waypoint(double latitude, double longitude, String userLabel) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.userLabel = userLabel;
    }

    public Waypoint(double latitude, double longitude, int transitRadius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.transitRadius = transitRadius;
    }

    public Waypoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public WaypointParameterTypeType getType() {
        return type;
    }

    public void setType(WaypointParameterTypeType type) {
        this.type = type;
    }

    public int getTransitRadius() {
        return transitRadius;
    }

    public void setTransitRadius(int transitRadius) {
        this.transitRadius = transitRadius;
    }

    @Override
    public String toString() {
        return "Waypoint{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", userLabel='" + userLabel + '\'' +
                ", type=" + type +
                ", transitRadius=" + transitRadius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Waypoint that = (Waypoint) o;

        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (Double.compare(that.altitude, altitude) != 0) return false;
        if (transitRadius != that.transitRadius) return false;
        if (userLabel != null ? !userLabel.equals(that.userLabel) : that.userLabel != null) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(altitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (userLabel != null ? userLabel.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + transitRadius;
        return result;
    }

    public String toRequestString() {
        //Format: [geo!][Type!]Position[;TransitRadius[;UserLabel]]
        String ret = "";

        //[geo!]
        ret += PREFIX;

        //[Type!]
        if(type != null){
            ret += type + "!";
        }

        //Position
        ret += latitude + "," + longitude;
        //[altitude]
        if(!altitude.equals(Double.NaN)){
            ret += "," + altitude;
        }

        //[TransitRadius]
        if(transitRadius != 0){
            ret += ";" + transitRadius;
        }

        //[userLabel]
        if(userLabel != null) {
            if(transitRadius == 0) {
                ret += ";";
            }
            ret += ";" + userLabel;
        }

        return ret;
    }
}
