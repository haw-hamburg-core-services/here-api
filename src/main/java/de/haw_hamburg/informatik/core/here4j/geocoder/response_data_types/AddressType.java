package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * Address record of a Location. Attributes are normalized to US feature names and can be mapped to the local feature
 * levels (for example, state matches "Bundesland" in Germany) using mapping tables.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressType {

    /**
     * Assembled address value for displaying purposes.
     */
    @JsonProperty("Label")
    private String label;

    /**
     * ISO 3166-alpha-3 country code
     */
    @JsonProperty("Country")
    private String country;

    /**
     * Includes the first subdivision level below the country. Where commonly used, this is a state code such as
     * CA for California.
     */
    @JsonProperty("State")
    private String state;

    /**
     * county name together with the language information
     */
    @JsonProperty("County")
    private String county;

    /**
     * city name together with the language information.
     */
    @JsonProperty("City")
    private String city;

    /**
     * district name together with the language information.
     */
    @JsonProperty("District")
    private String district;

    /**
     * street name together with the language information
     */
    @JsonProperty("Street")
    private String street;

    /**
     * street name decomposed into the different name parts
     */
    @JsonProperty("StreetDetails")
    private String streetDetails;

    /**
     * House number together with the language information (if available)
     */
    @JsonProperty("HouseNumber")
    private String houseNumber;

    /**
     * Postal code
     */
    @JsonProperty("PostalCode")
    private String postalCode;

    /**
     * building name together with the language information
     */
    @JsonProperty("Building")
    private String building;

    public AddressType(String label, String country, String state, String county, String city, String district, String street, String streetDetails, String houseNumber, String postalCode, String building) {
        this.label = label;
        this.country = country;
        this.state = state;
        this.county = county;
        this.city = city;
        this.district = district;
        this.street = street;
        this.streetDetails = streetDetails;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.building = building;
    }

    public AddressType() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetDetails() {
        return streetDetails;
    }

    public void setStreetDetails(String streetDetails) {
        this.streetDetails = streetDetails;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "AddressType{" +
                "label='" + label + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", streetDetails='" + streetDetails + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", building='" + building + '\'' +
                '}';
    }
}
