package de.haw_hamburg.informatik.core.here4j.routing.base_data_types;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * The GeoCoordinateType represents a geographical position.
 */
public class GeoCoordinateType {
    /**
     * WGS-84 / degrees with (-90 <= Latitude <= 90), precision is limited to 7 positions after the decimal point
     */
    private double latitude;

    /**
     * Longitude
     * WGS-84 / degrees with (-180 <= Longitude <= 180) precision is limited to 7 positions after the decimal point
     */
    private double longitude;
    /**
     * Altitude
     * Altitude in meters. Optional.
     */
    private Double altitude = Double.NaN;

    public GeoCoordinateType(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public GeoCoordinateType() {
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

    public String getQueryParameterRepresentation(){
        String ret = latitude + "," + longitude;
        if(!altitude.equals(Double.NaN)){
            ret += "," + altitude;
        }
        return ret;
    }
}
