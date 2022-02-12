package com.gridnine.testing.filters;

import com.gridnine.testing.test.Flight;
import com.gridnine.testing.test.Segment;

import java.time.LocalDateTime;

public class DepartureBeforeCurrentTime implements Filter{
    @Override
    public boolean check(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                return true;
            }
        }
        return false;
    }
}
