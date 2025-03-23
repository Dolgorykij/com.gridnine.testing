import com.gridnine.testing.FlightBuilder;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.Imlp.ArrivalBeforeDepartureFlightFilterService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrivalBeforeDepartureFlightFilterServiceTest {

    @Test
    void testFilter() {
        LocalDateTime now = LocalDateTime.now();
        Flight flight1 = FlightBuilder.createFlight(now, now.plusHours(2)); // Корректный сегмент
        Flight flight2 = FlightBuilder.createFlight(now, now.minusHours(2)); // Некорректный сегмент
        List<Flight> flights = List.of(flight1, flight2);

        ArrivalBeforeDepartureFlightFilterService filter = new ArrivalBeforeDepartureFlightFilterService();
        List<Flight> filteredFlights = filter.filter(flights);

        assertEquals(1, filteredFlights.size());
        assertEquals(flight1, filteredFlights.get(0));
    }
}
