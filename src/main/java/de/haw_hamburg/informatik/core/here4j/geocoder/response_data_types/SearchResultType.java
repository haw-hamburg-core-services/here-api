package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * The SearchResult contains the actual result as a Location object together with information on how good the result
 * matches the search request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultType {

    /**
     * Indicates the relevance of the results found; the higher the score the more relevant the alternative.
     * The score is a normalized value between 0 and 1.
     */
    private double Relevance;

    /**
     * Distance between the identified location object and the specified client position in meters. Only provided if a
     * proximity was specified in the request (parameter prox). For areas like admin or landmark areas the distance is
     * defined as the distance between the input coordinate and the boundary of the area. If the area covers the input
     * coordinate the distance will be negative.
     */
    private double Distance;

    /**
     * The most detailed address field that matches the geocoding or reverse geocoding query.
     */
    private MatchLevelType MatchLevel;

    /**
     * Detailed information about the match quality on the attribute level. MatchQuality is always 1.0 for reverse geocode results.
     */
    private LocationMatchQualityType MatchQuality;

    /**
     * Quality of the location match.
     *      pointAddress Location matches exactly as Point Address.
     *      interpolated Location was interpolated.
     */
    private MatchTypeType MatchType;

    /**
     * The location that was found.
     */
    private LocationType Location;

    public SearchResultType(double relevance, double distance, MatchLevelType matchLevel, LocationMatchQualityType matchQuality, MatchTypeType matchType, LocationType location) {
        Relevance = relevance;
        Distance = distance;
        MatchLevel = matchLevel;
        MatchQuality = matchQuality;
        MatchType = matchType;
        Location = location;
    }

    public SearchResultType() {
    }

    public double getRelevance() {
        return Relevance;
    }

    public void setRelevance(double relevance) {
        Relevance = relevance;
    }

    public double getDistance() {
        return Distance;
    }

    public void setDistance(double distance) {
        Distance = distance;
    }

    public MatchLevelType getMatchLevel() {
        return MatchLevel;
    }

    public void setMatchLevel(MatchLevelType matchLevel) {
        MatchLevel = matchLevel;
    }

    public LocationMatchQualityType getMatchQuality() {
        return MatchQuality;
    }

    public void setMatchQuality(LocationMatchQualityType matchQuality) {
        MatchQuality = matchQuality;
    }

    public MatchTypeType getMatchType() {
        return MatchType;
    }

    public void setMatchType(MatchTypeType matchType) {
        MatchType = matchType;
    }

    public LocationType getLocation() {
        return Location;
    }

    public void setLocation(LocationType location) {
        Location = location;
    }

    @Override
    public String toString() {
        return "SearchResultType{" +
                "Relevance=" + Relevance +
                ", Distance=" + Distance +
                ", MatchLevel=" + MatchLevel +
                ", MatchQuality=" + MatchQuality +
                ", MatchType=" + MatchType +
                ", Location=" + Location +
                '}';
    }
}
