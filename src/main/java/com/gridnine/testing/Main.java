package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilterService;
import com.gridnine.testing.service.Imlp.ArrivalBeforeDepartureFlightFilterService;
import com.gridnine.testing.service.Imlp.DepartureBeforeCurrentTimeFlightFilterService;
import com.gridnine.testing.service.Imlp.GroundTimeExceedsTwoHoursFlightFilterService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilterService departureFilter = new DepartureBeforeCurrentTimeFlightFilterService();
        FlightFilterService arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFlightFilterService();
        FlightFilterService groundTimeFilter = new GroundTimeExceedsTwoHoursFlightFilterService();

        List<Flight> filteredFlights1 = departureFilter.filter(flights);
        List<Flight> filteredFlights2 = arrivalBeforeDepartureFilter.filter(flights);
        List<Flight> filteredFlights3 = groundTimeFilter.filter(flights);


        System.out.println("Все перелёты:");
        flights.forEach(System.out::println);

        System.out.println("Перелёты после фильтрации (исключены вылеты до текущего времени):");
        filteredFlights1.forEach(System.out::println);

        System.out.println("Перелёты после фильтрации (исключены сегменты с датой прилёта раньше даты вылета):");
        filteredFlights2.forEach(System.out::println);

        System.out.println("Перелёты после фильтрации (исключены перелёты с общим временем на земле более 2 часов):");
        filteredFlights3.forEach(System.out::println);
    }
}

