import com.gridnine.testing.FlightBuilder;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.Imlp.DepartureBeforeCurrentTimeFlightFilterService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartureBeforeCurrentTimeFlightFilterServiceTest {

    @Test
    void testFilter() {
        LocalDateTime now = LocalDateTime.now();
        Flight flight1 = FlightBuilder.createFlight(now.minusHours(1), now.plusHours(2)); // Вылет в прошлом
        Flight flight2 = FlightBuilder.createFlight(now.plusHours(1), now.plusHours(3)); // Вылет в будущем
        List<Flight> flights = List.of(flight1, flight2);

        DepartureBeforeCurrentTimeFlightFilterService filter = new DepartureBeforeCurrentTimeFlightFilterService();
        List<Flight> filteredFlights = filter.filter(flights);

        assertEquals(1, filteredFlights.size());
        assertEquals(flight2, filteredFlights.get(0));
    }
}
