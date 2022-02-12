package com.gridnine.testing;

import com.gridnine.testing.filters.ArrivalBeforeDepartureDate;
import com.gridnine.testing.filters.DepartureBeforeCurrentTime;
import com.gridnine.testing.filters.MoreTwoHoursGroundTime;
import com.gridnine.testing.module.FlightFilter;
import com.gridnine.testing.test.Flight;
import com.gridnine.testing.test.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println("\n1. Вылет до текущего момента времени\n");
        List<Flight> listNumber1 = FlightFilter.getInstance().check(flightList, new DepartureBeforeCurrentTime());
        System.out.println(listNumber1);
        System.out.println("\n2. Cегменты с датой прилёта раньше даты вылета\n");
        List<Flight> listNumber2 = FlightFilter.getInstance().check(flightList, new ArrivalBeforeDepartureDate());
        System.out.println(listNumber2);
        System.out.println("\n3. Общее время, проведённое на земле превышает два часа \n");
        List<Flight> listNUmber3 = FlightFilter.getInstance().check(flightList, new MoreTwoHoursGroundTime());
        listNUmber3.forEach(flight -> System.out.println(flight.toString()));
    }
}
