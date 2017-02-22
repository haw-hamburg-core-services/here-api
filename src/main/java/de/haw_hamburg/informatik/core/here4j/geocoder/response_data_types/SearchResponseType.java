package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * The SearchResponse structure is the top level element returned by geocode, reverse geocode and landmark geocode
 * requests. It contains Meta Information and one or more view elements. Each view consists of a list of Results
 * wrapping the actual Location object found for the request together with information about the Match Quality of the
 * result.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseType {

    /**
     * Meta Information about the Request
     */
    @JsonProperty("MetaInfo")
    private SearchResponseMetaInfoType metaInfo;

    /**
     * Search Results are grouped in Views.
     */
    @JsonProperty("View")
    private SearchResultsViewType[] view;

    public SearchResponseType(SearchResponseMetaInfoType metaInfo, SearchResultsViewType[] view) {
        this.metaInfo = metaInfo;
        this.view = view;
    }

    public SearchResponseType() {
    }

    public SearchResponseMetaInfoType getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(SearchResponseMetaInfoType metaInfo) {
        this.metaInfo = metaInfo;
    }

    public SearchResultsViewType[] getView() {
        return view;
    }

    public void setView(SearchResultsViewType[] view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "SearchResponseType{" +
                "metaInfo=" + metaInfo +
                ", view=" + Arrays.toString(view) +
                '}';
    }
}
