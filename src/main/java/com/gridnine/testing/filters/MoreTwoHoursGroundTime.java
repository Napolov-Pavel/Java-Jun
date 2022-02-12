package com.gridnine.testing.filters;

import com.gridnine.testing.test.Flight;
import com.gridnine.testing.test.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class MoreTwoHoursGroundTime implements Filter{
    @Override
    public boolean check(Flight flight) {
        if (flight.getSegments().size() > 1) {
            List<Segment> segmentList = flight.getSegments();
            long groundTime = 0;
            for (int i = 0; i < segmentList.size() - 1; i++) {
                LocalDateTime arrival = segmentList.get(i).getArrivalDate();
                LocalDateTime departureNext = segmentList.get(i + 1).getDepartureDate();
                groundTime += arrival.until(departureNext, ChronoUnit.MINUTES);
            }
            int hourMinutes = 60;
            return groundTime / hourMinutes >= 2;
        }
        return false;
    }
}
