package com.gridnine.testing.service.Imlp;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilterService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр, исключающий рейсы, вылет которых происходит до текущего момента времени.
 */
public class DepartureBeforeCurrentTimeFlightFilterService implements FlightFilterService {

    /**
     * Возвращает список рейсов, где время вылета не раньше текущего времени.
     *
     * @param flights список всех рейсов
     * @return отфильтрованный список рейсов
     */
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
