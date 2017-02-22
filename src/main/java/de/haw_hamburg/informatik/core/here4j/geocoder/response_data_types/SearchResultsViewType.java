package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * Created by TimoHäckel on 22.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultsViewType {

    private String _type;

    /**
     * A key to distinguish between different types of views. Always set to 0.
     */
    private String ViewId;

    /**
     * The resulting items which have been found along with attributes indicating the quality of the search result.
     */
    private SearchResultType[] Result;

    public SearchResultsViewType(String _type, String viewId, SearchResultType[] result) {
        this._type = _type;
        ViewId = viewId;
        Result = result;
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
        return ViewId;
    }

    public void setViewId(String viewId) {
        ViewId = viewId;
    }

    public SearchResultType[] getResult() {
        return Result;
    }

    public void setResult(SearchResultType[] result) {
        Result = result;
    }

    @Override
    public String toString() {
        return "SearchResultsViewType{" +
                "_type='" + _type + '\'' +
                ", ViewId='" + ViewId + '\'' +
                ", Result=" + Arrays.toString(Result) +
                '}';
    }
}
