package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1.Создаем полет.
        List<Flight> flights = FlightBuilder.createFlights();
        // 2.Создаем FilterManager (управляет фильтрами: добавляет\убирает).
        FilterManager manager = new FilterManager();
        // 3.Создаем нужные фильтры.
        // 3.1. вылет до текущего момента времени
        Filter toCurrentTime = new DepartureToCurrentMomentOfTime();
        // 3.2. имеются сегменты с датой прилёта раньше даты вылета
        Filter earlierThanDepartureDate = new SegmentsWithArrivalDateEarlierThanDepartureDate();
        // 3.3. общее время, проведённое на земле превышает два часа
        Filter totalRechargeTime = new TotalTimeSpentOnEarthExceedTwoHours();
        // 4.Добавляем в FilterManager фильтры.
//        manager.add(toCurrentTime,earlierThanDepartureDate,totalRechargeTime);
        manager.add(totalRechargeTime);
        // 5.Применяем FilterManager к полету.
        flights.stream().forEach(System.out::println);
        System.out.println("===========================================================================");
        manager.apply(flights).stream().forEach(System.out::println);
    }
}
