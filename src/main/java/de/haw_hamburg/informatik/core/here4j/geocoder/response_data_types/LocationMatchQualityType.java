package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private double Country;

    /**
     * Match quality of the result with respect to state information in the request.
     */
    private double State;

    /**
     * Match quality of the result with respect to city information in the request.
     */
    private double City;

    /**
     * Match quality of the result with respect to district information in the request.
     */
    private double District;

    /**
     * Match quality of the result with respect to county information in the request.
     */
    private double County;

    /**
     * Match quality of the result with respect to sub-district information in the request.
     */
    private double Subdistrict;

    /**
     * Match quality of the result with respect to street information in the request. There are two values of 'Street'
     * when you specify an intersection.
     */
    private double [] Street;

    /**
     * Match quality of the result with respect to house number information in the request.
     */
    private double HouseNumber;

    /**
     * Match quality of the result with respect to postal code information in the request
     */
    private double PostalCode;

    /**
     * Match quality of the result with respect to building information in the request.
     */
    private double Building;

    public LocationMatchQualityType(double country, double state, double city, double district, double county, double subdistrict, double[] street, double houseNumber, double postalCode, double building) {
        Country = country;
        State = state;
        City = city;
        District = district;
        County = county;
        Subdistrict = subdistrict;
        Street = street;
        HouseNumber = houseNumber;
        PostalCode = postalCode;
        Building = building;
    }

    public LocationMatchQualityType() {
    }

    public double getCounty() {
        return County;
    }

    public void setCounty(double county) {
        County = county;
    }

    public double getCountry() {
        return Country;
    }

    public void setCountry(double country) {
        Country = country;
    }

    public double getState() {
        return State;
    }

    public void setState(double state) {
        State = state;
    }

    public double getCity() {
        return City;
    }

    public void setCity(double city) {
        City = city;
    }

    public double getDistrict() {
        return District;
    }

    public void setDistrict(double district) {
        District = district;
    }

    public double getSubdistrict() {
        return Subdistrict;
    }

    public void setSubdistrict(double subdistrict) {
        Subdistrict = subdistrict;
    }

    public double[] getStreet() {
        return Street;
    }

    public void setStreet(double[] street) {
        Street = street;
    }

    public double getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(double houseNumber) {
        HouseNumber = houseNumber;
    }

    public double getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(double postalCode) {
        PostalCode = postalCode;
    }

    public double getBuilding() {
        return Building;
    }

    public void setBuilding(double building) {
        Building = building;
    }

    @Override
    public String toString() {
        return "LocationMatchQualityType{" +
                "Country=" + Country +
                ", State=" + State +
                ", City=" + City +
                ", District=" + District +
                ", County=" + County +
                ", Subdistrict=" + Subdistrict +
                ", Street=" + Arrays.toString(Street) +
                ", HouseNumber=" + HouseNumber +
                ", PostalCode=" + PostalCode +
                ", Building=" + Building +
                '}';
    }
}
