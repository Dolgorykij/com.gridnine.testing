package com.gridnine.testing.service.Imlp;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightFilterService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр, исключающий рейсы с общим временем ожидания более двух часов.
 */
public class GroundTimeExceedsTwoHoursFlightFilterService implements FlightFilterService {

    /**
     * Возвращает список рейсов, у которых общее время на земле не превышает 2 часов.
     *
     * @param flights список всех рейсов
     * @return отфильтрованный список рейсов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    if (segments.size() <= 1) {
                        return true;
                    }

                    long totalGroundMinutes = 0;
                    for (int i = 1; i < segments.size(); i++) {
                        LocalDateTime previousArrival = segments.get(i - 1).getArrivalDate();
                        LocalDateTime currentDeparture = segments.get(i).getDepartureDate();
                        totalGroundMinutes += Duration.between(previousArrival, currentDeparture).toMinutes();
                    }
                    return totalGroundMinutes <= 120;
                })
                .collect(Collectors.toList());
    }
}
