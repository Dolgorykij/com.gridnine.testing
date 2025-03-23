package com.gridnine.testing.service.Imlp;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilterService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeCurrentTimeFlightFilterService implements FlightFilterService {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> {
                    LocalDateTime departure = flight.getSegments().get(0).getDepartureDate();
                    return !departure.isBefore(now);
                })
                .collect(Collectors.toList());
    }
}
