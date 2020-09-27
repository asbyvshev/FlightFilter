package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TotalTimeSpentOnEarthExceedTwoHours implements Filter {
    @Override
    public List<Flight> make(List<Flight> flights) {
        List<Flight> filerFlights = new ArrayList<>(flights);
        for (Flight f : flights) {
          List<Segment> segList = f.getSegments();
          if (segList.size() < 2) {
              continue;
          }
          LocalDateTime startFlight = LocalDateTime.now();
          LocalDateTime endFlight = LocalDateTime.now();
          long totalHoursInAir = 0;
            for (int i = 0; i < segList.size(); i++) {
                if (i == 0) {
                    startFlight = segList.get(i).getDepartureDate();
                }
                if (i == segList.size() - 1){
                    endFlight = segList.get(i).getArrivalDate();
                }
                totalHoursInAir += ChronoUnit.MINUTES.between(segList.get(i).getDepartureDate(),
                        segList.get(i).getArrivalDate());
            }
          long totalHoursFlight = ChronoUnit.MINUTES.between(startFlight,endFlight);
            if (totalHoursFlight - totalHoursInAir > 120){
                filerFlights.remove(f);
            }
        }
        return filerFlights;
    }
}
