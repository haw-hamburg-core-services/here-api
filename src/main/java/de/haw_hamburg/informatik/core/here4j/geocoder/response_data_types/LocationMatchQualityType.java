package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * MatchQuality provides detailed information about the match quality of a result at attribute level.
 * Match quality is a value between 0.0 and 1.0. 1.0 represents a 100% match.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationMatchQualityType {

    /**
     * Match quality of the result with respect to country information in the request.
     */
    @JsonProperty("Country")
    private double country;

    /**
     * Match quality of the result with respect to state information in the request.
     */
    @JsonProperty("State")
    private double state;

    /**
     * Match quality of the result with respect to city information in the request.
     */
    @JsonProperty("City")
    private double city;

    /**
     * Match quality of the result with respect to district information in the request.
     */
    @JsonProperty("District")
    private double district;

    /**
     * Match quality of the result with respect to county information in the request.
     */
    @JsonProperty("County")
    private double county;

    /**
     * Match quality of the result with respect to sub-district information in the request.
     */
    @JsonProperty("Subdistrict")
    private double subdistrict;

    /**
     * Match quality of the result with respect to street information in the request. There are two values of 'street'
     * when you specify an intersection.
     */
    @JsonProperty("Street")
    private double [] street;

    /**
     * Match quality of the result with respect to house number information in the request.
     */
    @JsonProperty("HouseNumber")
    private double houseNumber;

    /**
     * Match quality of the result with respect to postal code information in the request
     */
    @JsonProperty("PostalCode")
    private double postalCode;

    /**
     * Match quality of the result with respect to building information in the request.
     */
    @JsonProperty("Building")
    private double building;

    public LocationMatchQualityType(double country, double state, double city, double district, double county, double subdistrict, double[] street, double houseNumber, double postalCode, double building) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.district = district;
        this.county = county;
        this.subdistrict = subdistrict;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.building = building;
    }

    public LocationMatchQualityType() {
    }

    public double getCounty() {
        return county;
    }

    public void setCounty(double county) {
        this.county = county;
    }

    public double getCountry() {
        return country;
    }

    public void setCountry(double country) {
        this.country = country;
    }

    public double getState() {
        return state;
    }

    public void setState(double state) {
        this.state = state;
    }

    public double getCity() {
        return city;
    }

    public void setCity(double city) {
        this.city = city;
    }

    public double getDistrict() {
        return district;
    }

    public void setDistrict(double district) {
        this.district = district;
    }

    public double getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(double subdistrict) {
        this.subdistrict = subdistrict;
    }

    public double[] getStreet() {
        return street;
    }

    public void setStreet(double[] street) {
        this.street = street;
    }

    public double getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(double houseNumber) {
        this.houseNumber = houseNumber;
    }

    public double getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(double postalCode) {
        this.postalCode = postalCode;
    }

    public double getBuilding() {
        return building;
    }

    public void setBuilding(double building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "LocationMatchQualityType{" +
                "country=" + country +
                ", state=" + state +
                ", city=" + city +
                ", district=" + district +
                ", county=" + county +
                ", subdistrict=" + subdistrict +
                ", street=" + Arrays.toString(street) +
                ", houseNumber=" + houseNumber +
                ", postalCode=" + postalCode +
                ", building=" + building +
                '}';
    }
}
