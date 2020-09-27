package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SegmentsWithArrivalDateEarlierThanDepartureDateTest {
    List<Flight> flights;
    SegmentsWithArrivalDateEarlierThanDepartureDate earlierThanDepartureDate;

    @Before
    public void init(){
        flights = FlightBuilder.createFlights();
        earlierThanDepartureDate = new SegmentsWithArrivalDateEarlierThanDepartureDate();
    }

    @Test
    public void testMake(){
        Assert.assertEquals(5,earlierThanDepartureDate.make(flights).size());
    }
}
