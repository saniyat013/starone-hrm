package com.saniyat.webproject.entity.ticket;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String departure;
    private String destination;
    private Date journeyDate;
    private String airline;
    private Float baseFare;
    private Float tax;
    private Float totalFare;

    public Ticket() {
    }

    public Ticket(String departure, String destination, Date journeyDate , String airline, Float baseFare, Float tax, Float totalFare) {
        this.departure = departure;
        this.destination = destination;
        this.journeyDate = journeyDate;
        this.airline = airline;
        this.baseFare = baseFare;
        this.tax = tax;
        this.totalFare = totalFare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Float getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(Float baseFare) {
        this.baseFare = baseFare;
    }

    public Float getTax() {
        return tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

    public Float getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(Float totalFare) {
        this.totalFare = totalFare;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", journeyDate=" + journeyDate +
                ", airline='" + airline + '\'' +
                ", baseFare=" + baseFare +
                ", tax=" + tax +
                ", totalFare=" + totalFare +
                '}';
    }
}
