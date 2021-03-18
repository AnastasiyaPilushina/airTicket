package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirTicket;
import ru.netology.repository.AirTicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class AirTicketManagerTest {
    private AirTicketRepository repository = new AirTicketRepository();
    private AirTicketManager manager = new AirTicketManager(repository);
    private AirTicket first = new AirTicket(1, 25_000,"DME", "TlV", 720);
    private AirTicket second = new AirTicket(2, 75_000, "AER", "USM",1_300);
    private AirTicket third = new AirTicket(3, 10_000, "AER", "KEJ",300);
    private AirTicket forth = new AirTicket(4, 60_000, "AER", "USM",1_440);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
    }
    @Test
    public void shouldNotFound() {
        String airportFrom = "TPE";
        String airportTo = "PAR";

        AirTicket[] expected = new AirTicket[0];
        AirTicket[] actual = manager.findAll(airportFrom,airportTo);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldFoundAll() {
        String airportFrom = "AER";
        String airportTo = "USM";

        AirTicket[] expected = new AirTicket[]{forth, second};
        AirTicket[] actual = manager.findAll(airportFrom,airportTo);
        assertArrayEquals(expected,actual);
    }

}