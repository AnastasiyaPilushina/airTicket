package ru.netology.domain;

public class AirTicket implements Comparable <AirTicket>{
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int travelTimeMin;

    public AirTicket(int id) {
        this.id = id;
    }

    public AirTicket(int id, int price, String airportFrom, String airportTo, int travelTimeMin) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.travelTimeMin = travelTimeMin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public int getTravelTimeMin() {
        return travelTimeMin;
    }

    public void setTravelTimeMin(int travelTimeMin) {
        this.travelTimeMin = travelTimeMin;
    }

    @Override
    public int compareTo(AirTicket o) {
        return price - o.price;
    }

}