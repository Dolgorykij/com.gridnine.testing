package com.gridnine.testing.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Класс представляет сегмент рейса с временем вылета и прилёта.
 */
public class Segment {
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    /**
     * Конструктор сегмента.
     * @param dep дата и время вылета
     * @param arr дата и время прилёта
     */
    public Segment(final LocalDateTime dep, final LocalDateTime arr) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
    }

    /**
     * Получить дату и время вылета.
     * @return дата и время вылета
     */
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    /**
     * Получить дату и время прилёта.
     * @return дата и время прилёта
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}
