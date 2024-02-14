package com.mybus.busdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybus.busdatabase.repository.BusRepository;
import com.mybus.busdatabase.service.BusService;
import com.mybus.busdatabase.entity.BusEntity;
import com.mybus.busdatabase.model.Bus;

@RestController
@RequestMapping("/api/buses")
@CrossOrigin(origins = "*")
public class BusController {
    
	
	@Autowired
    private BusRepository busRepository;

	@Autowired
    private BusService busService;
	
    @GetMapping(value="/search" , produces="application/json")
    public List<Bus> searchBuses(@RequestParam String fromCity, @RequestParam String toCity) {
        return busService.getBuses(fromCity,toCity);
    }
    
    @GetMapping(value="/all",produces="application/json")
    public List<Bus> allBuses() {
        return busService.getAllBuses();
    }
     
    
    @PostMapping("/add")
    public ResponseEntity<String> addBus(@RequestBody Bus bus) {
        // Call the service method to add the bus to the database
        busService.addBus(bus);
        return ResponseEntity.ok("Bus added successfully");
    }

}
