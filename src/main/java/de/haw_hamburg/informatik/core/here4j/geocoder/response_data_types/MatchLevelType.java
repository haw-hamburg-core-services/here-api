package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * The most detailed address field that matches the geocoding or reverse geocoding query.
 */
public enum MatchLevelType {
    country, state, county, city, district, street, intersection, houseNumber, postalCode, landmark
}
