package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * Meta information which is not directly related to the route calculation is wrapped within a separate element.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteResponseMetaInfoType {

    /**
     * Mirrored RequestId value from the request structure. Used to trace requests.
     */
    private String requestId;
    /**
     * Time at which the search was performed.
     */
    private String timestamp;
    /**
     * Gives the version of the underlying map, upon which the route calculations are based.
     */
    private String mapVersion;
    /**
     * Gives the version of the module that performed the route calculations.
     */
    private String moduleVersion;
    /**
     * Required. Gives the version of the schema definition to enable formats other than XML to identify elements
     * without using namespaces.
     */
    private String interfaceVersion;

    public RouteResponseMetaInfoType() {
    }

    public RouteResponseMetaInfoType(String requestId, String timestamp, String mapVersion, String moduleVersion, String interfaceVersion) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.mapVersion = mapVersion;
        this.moduleVersion = moduleVersion;
        this.interfaceVersion = interfaceVersion;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMapVersion() {
        return mapVersion;
    }

    public void setMapVersion(String mapVersion) {
        this.mapVersion = mapVersion;
    }

    public String getModuleVersion() {
        return moduleVersion;
    }

    public void setModuleVersion(String moduleVersion) {
        this.moduleVersion = moduleVersion;
    }

    public String getInterfaceVersion() {
        return interfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        this.interfaceVersion = interfaceVersion;
    }

    @Override
    public String toString() {
        return "RouteResponseMetaInfoType{" +
                "requestId='" + requestId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", mapVersion='" + mapVersion + '\'' +
                ", moduleVersion='" + moduleVersion + '\'' +
                ", interfaceVersion='" + interfaceVersion + '\'' +
                '}';
    }
}
