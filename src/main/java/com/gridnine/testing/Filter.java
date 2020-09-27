package com.gridnine.testing;

import com.gridnine.testing.Flight;

import java.util.List;

public interface Filter {
    List<Flight> make(List<Flight> flights);
}
