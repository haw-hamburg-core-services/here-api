package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.haw_hamburg.informatik.core.here4j.base_data_types.GeoCoordinateType;

/**
 * Created by TimoHäckel on 22.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingResponse {

    @JsonProperty("Response")
    private SearchResponseType response;

    public GeocodingResponse() {
    }

    public GeocodingResponse(SearchResponseType response) {
        this.response = response;
    }

    public SearchResponseType getResponse() {
        return response;
    }

    public void setResponse(SearchResponseType response) {
        this.response = response;
    }

    public GeoCoordinateType getPosition(){
        SearchResultsViewType[] view = this.getResponse().getView();
        SearchResultType[] result = view[0].getResult();
        return result[0].getLocation().getDisplayPosition();
    }

    @Override
    public String toString() {
        return "GeocodingResponse{" +
                "response=" + response +
                '}';
    }
}
