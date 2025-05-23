package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс представляет авиарейс, состоящий из одного или нескольких сегментов.
 */
public class Flight {
    private final List<Segment> segments;

    /**
     * Конструктор рейса.
     * @param segs список сегментов, составляющих рейс
     */
    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    /**
     * Получить список сегментов рейса.
     * @return список сегментов
     */
    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
