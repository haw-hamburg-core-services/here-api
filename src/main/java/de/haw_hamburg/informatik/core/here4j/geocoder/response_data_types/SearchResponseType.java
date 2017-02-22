package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * The SearchResponse structure is the top level element returned by geocode, reverse geocode and landmark geocode
 * requests. It contains Meta Information and one or more View elements. Each view consists of a list of Results
 * wrapping the actual Location object found for the request together with information about the Match Quality of the
 * result.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseType {

    /**
     * Meta Information about the Request
     */
    private SearchResponseMetaInfoType MetaInfo;

    /**
     * Search Results are grouped in Views.
     */
    private SearchResultsViewType[] View;

    public SearchResponseType(SearchResponseMetaInfoType metaInfo, SearchResultsViewType[] view) {
        MetaInfo = metaInfo;
        View = view;
    }

    public SearchResponseType() {
    }

    public SearchResponseMetaInfoType getMetaInfo() {
        return MetaInfo;
    }

    public void setMetaInfo(SearchResponseMetaInfoType metaInfo) {
        MetaInfo = metaInfo;
    }

    public SearchResultsViewType[] getView() {
        return View;
    }

    public void setView(SearchResultsViewType[] view) {
        View = view;
    }
}
