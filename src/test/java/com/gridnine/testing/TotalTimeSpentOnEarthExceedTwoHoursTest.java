package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TotalTimeSpentOnEarthExceedTwoHoursTest {
    List<Flight> flights;
    TotalTimeSpentOnEarthExceedTwoHours totalRechargeTime;

    @Before
    public void init(){
        flights = FlightBuilder.createFlights();
        totalRechargeTime = new TotalTimeSpentOnEarthExceedTwoHours();
    }

    @Test
    public void testMake(){
        Assert.assertEquals(4,totalRechargeTime.make(flights).size());
    }
}
