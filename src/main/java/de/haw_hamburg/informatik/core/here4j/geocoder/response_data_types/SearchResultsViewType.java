package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by TimoHäckel on 22.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultsViewType {

    @JsonProperty("_type")
    private String _type;

    /**
     * A key to distinguish between different types of views. Always set to 0.
     */
    @JsonProperty("ViewId")
    private String viewId;

    /**
     * The resulting items which have been found along with attributes indicating the quality of the search result.
     */
    @JsonProperty("Result")
    private SearchResultType[] result;

    public SearchResultsViewType(String _type, String viewId, SearchResultType[] result) {
        this._type = _type;
        this.viewId = viewId;
        this.result = result;
    }

    public SearchResultsViewType() {
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public SearchResultType[] getResult() {
        return result;
    }

    public void setResult(SearchResultType[] result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SearchResultsViewType{" +
                "_type='" + _type + '\'' +
                ", viewId='" + viewId + '\'' +
                ", result=" + Arrays.toString(result) +
                '}';
    }
}
