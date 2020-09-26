package com.gridnine.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterManager {
    private List<Filter> filters;

    public void add(Filter ...filters) {
        if (this.filters == null){
            this.filters = new ArrayList<>();
        }
        this.filters.addAll(Arrays.asList(filters));
    }

    public void add(Filter filter) {
        if (filters == null) {
            filters = new ArrayList<>();
        }
        filters.add(filter);
    }

    public void remove(Filter filter){
        filters.remove(filter);
    }

    public List<Flight> apply(List<Flight> flights) {
        if (flights == null || flights.isEmpty()){
            throw new IllegalArgumentException(
                    "the list must contain at least one flight");
        }
        if (filters == null){
            throw new IllegalArgumentException(
                    "you must specify filters");
        }
        List<Flight> filteredList = flights;
        for (Filter filter:filters) {
            filteredList = filter.make(filteredList);
        }
        return filteredList;
    }
}
