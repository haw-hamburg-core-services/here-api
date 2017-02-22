package de.haw_hamburg.informatik.core.here4j.routing.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 22.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculateRouteResponse {

    private CalculateRouteResponseType response;

    public CalculateRouteResponse(CalculateRouteResponseType response) {
        this.response = response;
    }

    public CalculateRouteResponse() {
    }

    public CalculateRouteResponseType getResponse() {
        return response;
    }

    public void setResponse(CalculateRouteResponseType response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "CalculateRouteResponse{" +
                "response=" + response +
                '}';
    }
}
