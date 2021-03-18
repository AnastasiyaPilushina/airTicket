package ru.netology.manager;

import ru.netology.domain.AirTicket;

import java.util.Arrays;

import ru.netology.domain.AirTicket;
import ru.netology.repository.AirTicketRepository;

import java.util.Arrays;

public class AirTicketManager {
    private AirTicketRepository repository;

    public AirTicketManager(AirTicketRepository repository) {
        this.repository = repository;
    }

    public void add(AirTicket item) {
        repository.save(item);
    }

    public AirTicket[] findAll(String airportFrom, String airportTo) {
        AirTicket[] result = new AirTicket[0];
        for (AirTicket airTicket : repository.findAll()) {
            if (airTicket.getAirportFrom().equalsIgnoreCase(airportFrom) && airTicket.getAirportTo().equalsIgnoreCase(airportTo)) {
                AirTicket[] tmp = new AirTicket[result.length + 1];
                System.arraycopy(result,0,tmp, 0, result.length);
                tmp[tmp.length -1] =airTicket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}