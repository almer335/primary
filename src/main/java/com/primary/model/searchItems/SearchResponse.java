package com.primary.model.searchItems;

import java.util.List;

public class SearchResponse {

    private String query;
    private Paging paging;
    private List<ItemResponse> results;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<ItemResponse> getResults() {
        return results;
    }

    public void setResults(List<ItemResponse> results) {
        this.results = results;
    }

}

