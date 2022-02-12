package com.gridnine.testing.module;

import com.gridnine.testing.filters.Filter;
import com.gridnine.testing.test.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFilter {
    private static FlightFilter instance;

    private FlightFilter() {
    }

    public static FlightFilter getInstance() {
        if (instance == null) {
            instance = new FlightFilter();
        }
        return instance;
    }
    List<Flight> check(List<Flight> flightList, Filter filter) {
        return flightList.stream()
                .filter(filter::check)
                .collect(Collectors.toList());
    }

}
