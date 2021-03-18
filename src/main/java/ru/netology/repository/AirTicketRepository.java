package ru.netology.repository;

import ru.netology.domain.AirTicket;
import ru.netology.exception.NotFoundException;

public class AirTicketRepository {
    private AirTicket[] items = new AirTicket[0];

    public void save(AirTicket item) {
        int length = items.length + 1;
        AirTicket[] tmp = new AirTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AirTicket[] findAll() {
        return items;
    }

    public AirTicket findById(int id) {
        for (AirTicket airTicket : items ) {
            if (airTicket.getId() == id) {
                return airTicket;
            }
        }
        return null;
    }


    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            int length = items.length - 1;
            AirTicket[] tmp = new AirTicket[length];
            int index = 0;
            for (AirTicket item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }

}