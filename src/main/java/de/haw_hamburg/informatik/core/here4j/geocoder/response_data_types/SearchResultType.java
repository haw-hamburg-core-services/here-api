package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * The SearchResult contains the actual result as a location object together with information on how good the result
 * matches the search request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultType {

    /**
     * Indicates the relevance of the results found; the higher the score the more relevant the alternative.
     * The score is a normalized value between 0 and 1.
     */
    @JsonProperty("Relevance")
    private double relevance;

    /**
     * distance between the identified location object and the specified client position in meters. Only provided if a
     * proximity was specified in the request (parameter prox). For areas like admin or landmark areas the distance is
     * defined as the distance between the input coordinate and the boundary of the area. If the area covers the input
     * coordinate the distance will be negative.
     */
    @JsonProperty("Distance")
    private double distance;

    /**
     * The most detailed address field that matches the geocoding or reverse geocoding query.
     */
    @JsonProperty("MatchLevel")
    private MatchLevelType matchLevel;

    /**
     * Detailed information about the match quality on the attribute level. matchQuality is always 1.0 for reverse geocode results.
     */
    @JsonProperty("MatchQuality")
    private LocationMatchQualityType matchQuality;

    /**
     * Quality of the location match.
     *      pointAddress location matches exactly as Point Address.
     *      interpolated location was interpolated.
     */
    @JsonProperty("MatchType")
    private MatchTypeType matchType;

    /**
     * The location that was found.
     */
    @JsonProperty("Location")
    private LocationType location;

    public SearchResultType(double relevance, double distance, MatchLevelType matchLevel, LocationMatchQualityType matchQuality, MatchTypeType matchType, LocationType location) {
        this.relevance = relevance;
        this.distance = distance;
        this.matchLevel = matchLevel;
        this.matchQuality = matchQuality;
        this.matchType = matchType;
        this.location = location;
    }

    public SearchResultType() {
    }

    public double getRelevance() {
        return relevance;
    }

    public void setRelevance(double relevance) {
        this.relevance = relevance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public MatchLevelType getMatchLevel() {
        return matchLevel;
    }

    public void setMatchLevel(MatchLevelType matchLevel) {
        this.matchLevel = matchLevel;
    }

    public LocationMatchQualityType getMatchQuality() {
        return matchQuality;
    }

    public void setMatchQuality(LocationMatchQualityType matchQuality) {
        this.matchQuality = matchQuality;
    }

    public MatchTypeType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchTypeType matchType) {
        this.matchType = matchType;
    }

    public LocationType getLocation() {
        return location;
    }

    public void setLocation(LocationType location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "SearchResultType{" +
                "relevance=" + relevance +
                ", distance=" + distance +
                ", matchLevel=" + matchLevel +
                ", matchQuality=" + matchQuality +
                ", matchType=" + matchType +
                ", location=" + location +
                '}';
    }
}
