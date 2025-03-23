package com.gridnine.testing.service.Imlp;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilterService;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFlightFilterService implements FlightFilterService {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
