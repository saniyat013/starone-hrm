package com.saniyat.webproject.service;

import com.saniyat.webproject.dao.PassengerRepository;
import com.saniyat.webproject.entity.passenger.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    private PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository thePassengerRepository) {
        passengerRepository = thePassengerRepository;
    }

    @Override
    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger findById(int theId) {
        Optional<Passenger> result = passengerRepository.findById(theId);

        Passenger thePassenger = null;
        if (result.isPresent()) {
            thePassenger = result.get();
        } else {
            throw new RuntimeException("Did not find the passenger with id - " + theId);
        }
        return thePassenger;
    }

    @Override
    public Passenger save(Passenger thePassenger) {
        return passengerRepository.save(thePassenger);
    }

    @Override
    public void deleteById(int theId) {
        passengerRepository.deleteById(theId);
    }
}
