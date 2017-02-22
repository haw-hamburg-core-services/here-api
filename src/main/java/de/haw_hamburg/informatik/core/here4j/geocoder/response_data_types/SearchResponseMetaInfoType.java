package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * 	Meta Information about the Request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseMetaInfoType {

    /**
     * Mirrored requestId value from the request structure. Can be used to trace requests.
     */
    @JsonProperty("RequestId")
    private String requestId;

    /**
     * Time at which the search was performed.
     */
    @JsonProperty("Timestamp")
    private Date timestamp;

    public SearchResponseMetaInfoType(String requestId, Date timestamp) {
        this.requestId = requestId;
        this.timestamp = timestamp;
    }

    public SearchResponseMetaInfoType() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SearchResponseMetaInfoType{" +
                "requestId='" + requestId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
