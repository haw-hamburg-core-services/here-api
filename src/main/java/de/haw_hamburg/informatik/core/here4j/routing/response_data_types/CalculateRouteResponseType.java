package de.haw_hamburg.informatik.core.here4j.routing.response_data_types;

import de.haw_hamburg.informatik.core.here4j.routing.base_data_types.LanguageCodeType;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.RouteType;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * CalculateRouteResponseType contains response data, structured to match a particular request for the CalculateRoute
 * operation. The Route element may appear more than once in the response if multiple routes are available between the
 * start and end points. Refer to CalculateRouteRequestType, described in Calculate Route for details on associated
 * request elements.
 *
 * Data elements may be hidden if they contain no data.
 */
public class CalculateRouteResponseType {

    /**
     * Provides details about the request itself, such as the time at which it was processed, a request id, or the map
     * version on which the calculation was based.
     */
    private RouteResponseMetaInfoType metaInfo;

    /**
     * Contains the calculated path across a navigable link network, as specified in the request. Routes contain
     * navigation instructions for a single trip as: waypoints (fixed locations) and route legs (sections of the route
     * between waypoints). Each response may also include information about the route itself, such as its overall shape,
     * map location, or a summary description.
     */
    private RouteType route;

    /**
     * Indicates the language used for all textual information related to the route.
     *
     * If the requested language is unavailable, the service defaults to American English (en-us).
     */
    private LanguageCodeType language;

    /**
     * Mirrored RequestId value from the request structure. Used to trace requests.
     */
    private String requestId;

    public CalculateRouteResponseType(RouteResponseMetaInfoType metaInfo, RouteType route, LanguageCodeType language, String requestId) {
        this.metaInfo = metaInfo;
        this.route = route;
        this.language = language;
        this.requestId = requestId;
    }

    public CalculateRouteResponseType() {
    }

    public RouteResponseMetaInfoType getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(RouteResponseMetaInfoType metaInfo) {
        this.metaInfo = metaInfo;
    }

    public RouteType getRoute() {
        return route;
    }

    public void setRoute(RouteType route) {
        this.route = route;
    }

    public LanguageCodeType getLanguage() {
        return language;
    }

    public void setLanguage(LanguageCodeType language) {
        this.language = language;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
