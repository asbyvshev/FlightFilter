package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartureToCurrentMomentOfTime implements Filter {
    @Override
    public List<Flight> make(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        List<Flight> filerFlights = new ArrayList<>(flights);
        for (Flight f : flights) {
            for (Segment segment: f.getSegments()) {
                if (segment.getDepartureDate().isBefore(now)){
                    filerFlights.remove(f);
                }
            }
        }
        return filerFlights;
    }
}
