package com.gridnine.testing.filters;

import com.gridnine.testing.test.Flight;
import com.gridnine.testing.test.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilterTest {
    private Filter sut;

    @Test
    void shouldProperlyDepartureBeforeCurrentTime() {
        Segment segment = new Segment(LocalDateTime.now().minusDays(1), LocalDateTime.now());
        List<Segment> listTest = new ArrayList<>();
        listTest.add(segment);
        Flight flight = new Flight(listTest);
        sut = new DepartureBeforeCurrentTime();

        boolean result = sut.check(flight);

        assertTrue(result);
    }

    @Test
    void shouldProperlyArrivalBeforeDepartureDate() {
        Segment segment = new Segment(LocalDateTime.now(), LocalDateTime.now().minusDays(1));
        List<Segment> listTest = new ArrayList<>();
        listTest.add(segment);
        Flight flight = new Flight(listTest);
        sut = new ArrivalBeforeDepartureDate();

        boolean result = sut.check(flight);

        assertTrue(result);
    }

}