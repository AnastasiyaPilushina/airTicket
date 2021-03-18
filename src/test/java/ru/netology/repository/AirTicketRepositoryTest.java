package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirTicket;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.AirTicketManager;

import static org.junit.jupiter.api.Assertions.*;

class AirTicketRepositoryTest {
    private AirTicketRepository repository = new AirTicketRepository();
    private AirTicket first = new AirTicket(1, 25_000, "DME", "TlV", 720);
    private AirTicket second = new AirTicket(2, 55_000, "AER", "USM", 1_300);
    private AirTicket third = new AirTicket(3, 10_000, "AER", "KEJ", 300);


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }
    @Test
    public void shouldThrowCheckedException() {
        int idToRemove = 4;
        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
    }


    @Test
    public void shouldNotThrowCheckedException() {
        int idToRemove = 1;
        repository.removeById(idToRemove);
        AirTicket[] expected = new AirTicket[]{second, third};
        AirTicket[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }

}