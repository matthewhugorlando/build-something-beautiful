package com.ironyard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by matthewhug on 3/3/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsDTO {
    private long page;
    private List<Object> results;

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public List<Object> getResults() {
        return results;
    }

    public void setResults(List<Object> results) {
        this.results = results;
    }
}
