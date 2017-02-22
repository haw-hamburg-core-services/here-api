package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * 	Meta Information about the Request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseMetaInfoType {

    /**
     * Mirrored RequestId value from the request structure. Can be used to trace requests.
     */
    private String RequestId;

    /**
     * Time at which the search was performed.
     */
    private Date Timestamp;

    public SearchResponseMetaInfoType(String requestId, Date timestamp) {
        RequestId = requestId;
        Timestamp = timestamp;
    }

    public SearchResponseMetaInfoType() {
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Date timestamp) {
        Timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SearchResponseMetaInfoType{" +
                "RequestId='" + RequestId + '\'' +
                ", Timestamp=" + Timestamp +
                '}';
    }
}
