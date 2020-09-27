package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DepartureToCurrentMomentOfTimeTest {

    List<Flight> flights;
    DepartureToCurrentMomentOfTime toCurrentTime;

    @Before
    public void init(){
        flights = FlightBuilder.createFlights();
        toCurrentTime = new DepartureToCurrentMomentOfTime();
    }

    @Test
    public void testMake(){
        Assert.assertEquals(5,toCurrentTime.make(flights).size());
    }
}
