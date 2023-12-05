package com.saniyat.webproject.rest;

import com.saniyat.webproject.entity.passenger.Passenger;
import com.saniyat.webproject.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PassengerRestController {
    private PassengerService passengerService;

    @Autowired
    public PassengerRestController(PassengerService thePassengerService) {
        passengerService = thePassengerService;
    }

    @GetMapping("/passengers")
    public List<Passenger> findAll() {
        return passengerService.findAll();
    }

    @GetMapping("/passengers/{passengerId}")
    public Passenger getPassenger(@PathVariable int passengerId) {
        Passenger thePassenger = passengerService.findById(passengerId);

        if (thePassenger == null) {
            throw new RuntimeException("Passenger id not found - " + passengerId);
        }

        return thePassenger;
    }

    @PostMapping("/passengers")
    public Passenger addPassenger(@RequestBody Passenger thePassenger) {
        thePassenger.setId(0);
        Passenger dbPassenger = passengerService.save(thePassenger);
        return dbPassenger;
    }

    @PutMapping("/passengers")
    public Passenger updatePassenger(@RequestBody Passenger thePassenger) {
        Passenger dbPassenger = passengerService.save(thePassenger);
        return dbPassenger;
    }

    @DeleteMapping("passengers/{passengerId}")
    public String deletePassenger(@PathVariable int passengerId) {
        Passenger tempPassenger = passengerService.findById(passengerId);
        if (tempPassenger == null) {
            throw new RuntimeException("Passenger id not found - " + passengerId);
        }
        passengerService.deleteById(passengerId);
        return "Deleted passenger with id - " + passengerId;
    }
}
