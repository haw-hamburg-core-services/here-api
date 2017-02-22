package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 22.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingResponse {

    private SearchResponseType Response;

    public GeocodingResponse() {
    }

    public GeocodingResponse(SearchResponseType response) {
        this.Response = response;
    }

    public SearchResponseType getResponse() {
        return Response;
    }

    public void setResponse(SearchResponseType response) {
        this.Response = response;
    }

    @Override
    public String toString() {
        return "GeocodingResponse{" +
                "Response=" + Response +
                '}';
    }
}
