package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class SegmentsWithArrivalDateEarlierThanDepartureDate implements Filter {
    @Override
    public List<Flight> make(List<Flight> flights) {
        List<Flight> filerFlights = new ArrayList<>(flights);
        for (Flight f : flights) {
            for (Segment segment: f.getSegments()) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())){
                    filerFlights.remove(f);
                }
            }
        }
        return filerFlights;
    }
}
