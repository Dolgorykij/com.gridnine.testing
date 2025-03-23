import com.gridnine.testing.FlightBuilder;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.Imlp.GroundTimeExceedsTwoHoursFlightFilterService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroundTimeExceedsTwoHoursFlightFilterServiceTest {

    @Test
    void testFilter() {
        LocalDateTime now = LocalDateTime.now();
        Flight flight1 = FlightBuilder.createFlight(now, now.plusHours(2), now.plusHours(3), now.plusHours(5)); // Время на земле: 1 час
        Flight flight2 = FlightBuilder.createFlight(now, now.plusHours(2), now.plusHours(5), now.plusHours(6)); // Время на земле: 3 часа
        List<Flight> flights = List.of(flight1, flight2);

        GroundTimeExceedsTwoHoursFlightFilterService filter = new GroundTimeExceedsTwoHoursFlightFilterService();
        List<Flight> filteredFlights = filter.filter(flights);


        assertEquals(1, filteredFlights.size());
        assertEquals(flight1, filteredFlights.get(0));
    }
}
