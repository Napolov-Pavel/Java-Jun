package com.gridnine.testing.filters;

import com.gridnine.testing.test.Flight;
import com.gridnine.testing.test.Segment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MoreTwoHoursGroundTimeTest {
    private MoreTwoHoursGroundTime sut;
    private Segment segmentTest;
    private Segment segmentTest1;
    private Flight flightTest;
    private List<Segment> listTest;

    @BeforeEach
    void setUp() {
        sut = new MoreTwoHoursGroundTime();
        listTest = new ArrayList<>();
        flightTest = new Flight(listTest);
    }

    @AfterEach
    void tearDown() {
        sut = null;
        listTest = null;
        flightTest = null;
        segmentTest = null;
        segmentTest1 = null;
    }

    @Test
    void shouldProperlyCheckTrue() {
        segmentTest = new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now());
        segmentTest1 = new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3));
        listTest.add(segmentTest);
        listTest.add(segmentTest1);

        boolean result = sut.check(flightTest);

        assertTrue(result);
    }

    @Test
    void shouldProperlyCheckFalse() {
        segmentTest = new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now());
        segmentTest1 = new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2));
        listTest.add(segmentTest);
        listTest.add(segmentTest1);

        boolean result = sut.check(flightTest);

        assertFalse(result);
    }
}