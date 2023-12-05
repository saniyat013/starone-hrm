package com.saniyat.webproject.service;

import com.saniyat.webproject.entity.passenger.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> findAll();

    Passenger findById(int theId);

    Passenger save(Passenger thePassenger);

    void deleteById(int theId);
}
