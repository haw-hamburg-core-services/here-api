package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * Address record of a Location. Attributes are normalized to US feature names and can be mapped to the local feature
 * levels (for example, State matches "Bundesland" in Germany) using mapping tables.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressType {

    /**
     * Assembled address value for displaying purposes.
     */
    private String Label;

    /**
     * ISO 3166-alpha-3 country code
     */
    private String Country;

    /**
     * Includes the first subdivision level below the country. Where commonly used, this is a state code such as
     * CA for California.
     */
    private String State;

    /**
     * County name together with the language information
     */
    private String County;

    /**
     * City name together with the language information.
     */
    private String City;

    /**
     * District name together with the language information.
     */
    private String District;

    /**
     * Street name together with the language information
     */
    private String Street;

    /**
     * Street name decomposed into the different name parts
     */
    private String StreetDetails;

    /**
     * House number together with the language information (if available)
     */
    private String HouseNumber;

    /**
     * Postal code
     */
    private String PostalCode;

    /**
     * Building name together with the language information
     */
    private String Building;

    public AddressType(String label, String country, String state, String county, String city, String district, String street, String streetDetails, String houseNumber, String postalCode, String building) {
        Label = label;
        Country = country;
        State = state;
        County = county;
        City = city;
        District = district;
        Street = street;
        StreetDetails = streetDetails;
        HouseNumber = houseNumber;
        PostalCode = postalCode;
        Building = building;
    }

    public AddressType() {
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getStreetDetails() {
        return StreetDetails;
    }

    public void setStreetDetails(String streetDetails) {
        StreetDetails = streetDetails;
    }

    public String getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        HouseNumber = houseNumber;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getBuilding() {
        return Building;
    }

    public void setBuilding(String building) {
        Building = building;
    }

    @Override
    public String toString() {
        return "AddressType{" +
                "Label='" + Label + '\'' +
                ", Country='" + Country + '\'' +
                ", State='" + State + '\'' +
                ", County='" + County + '\'' +
                ", City='" + City + '\'' +
                ", District='" + District + '\'' +
                ", Street='" + Street + '\'' +
                ", StreetDetails='" + StreetDetails + '\'' +
                ", HouseNumber='" + HouseNumber + '\'' +
                ", PostalCode='" + PostalCode + '\'' +
                ", Building='" + Building + '\'' +
                '}';
    }
}
