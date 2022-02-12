package com.gridnine.testing.module;

import com.gridnine.testing.filters.DepartureBeforeCurrentTime;
import com.gridnine.testing.test.Flight;
import com.gridnine.testing.test.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterTest {

    @Test
    void shouldProperlyCheck() {
        FlightFilter sut = FlightFilter.getInstance();
        Segment segment = new Segment(LocalDateTime.now(), LocalDateTime.now().minusDays(1));
        List<Segment> listTest = new ArrayList<>();
        listTest.add(segment);
        Flight flightTest = new Flight(listTest);
        List<Flight> expected = new ArrayList<>();
        expected.add(flightTest);

        List<Flight> result = sut.check(expected, new DepartureBeforeCurrentTime());

        Assertions.assertEquals(expected, result);
    }
}