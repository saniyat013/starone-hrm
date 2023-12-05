package com.saniyat.webproject.dao;

import com.saniyat.webproject.entity.passenger.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
