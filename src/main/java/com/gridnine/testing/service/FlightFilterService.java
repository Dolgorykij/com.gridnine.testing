package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightFilterService {
    List<Flight> filter(List<Flight> flights);
}
