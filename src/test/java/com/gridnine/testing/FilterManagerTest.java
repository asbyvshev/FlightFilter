package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FilterManagerTest {

    FilterManager filterManager;

    @Before
    public void init(){
        filterManager = new FilterManager();
    }

    @Test
    public void testAddArray() {
        filterManager.add(new DepartureToCurrentMomentOfTime(),
                new DepartureToCurrentMomentOfTime());
        Assert.assertEquals(2,filterManager.getFilters().size());
    }

    @Test
    public void testAdd() {
        filterManager.add(new DepartureToCurrentMomentOfTime());
        Assert.assertEquals(1,filterManager.getFilters().size());
    }

    @Test
    public void testRemove(){
        Filter filter1 = new DepartureToCurrentMomentOfTime();
        Filter filter2 = new SegmentsWithArrivalDateEarlierThanDepartureDate();
        filterManager.add(filter1,filter2);
        filterManager.remove(filter1);
        Assert.assertEquals(1,filterManager.getFilters().size());
    }

    @Test
    public void testApply() {
        filterManager.add(new DepartureToCurrentMomentOfTime()
                ,new SegmentsWithArrivalDateEarlierThanDepartureDate()
                ,new TotalTimeSpentOnEarthExceedTwoHours());
        Assert.assertEquals(2,filterManager.apply(FlightBuilder.createFlights()).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApply1() {
        filterManager.apply(FlightBuilder.createFlights());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApply2() {
        filterManager.add();
        filterManager.apply(null);
    }
}
