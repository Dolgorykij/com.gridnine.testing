package com.gridnine.testing.service.Imlp;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilterService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр, исключающий рейсы, в которых дата прилёта раньше даты вылета.
 */
public class ArrivalBeforeDepartureFlightFilterService implements FlightFilterService {

    /**
     * Возвращает список рейсов, в которых каждый сегмент имеет корректное соотношение времени вылета и прилёта.
     *
     * @param flights список всех рейсов
     * @return отфильтрованный список рейсов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
