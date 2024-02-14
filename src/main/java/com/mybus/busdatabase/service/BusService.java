package com.mybus.busdatabase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybus.busdatabase.entity.BusEntity;
import com.mybus.busdatabase.model.Bus;
import com.mybus.busdatabase.repository.BusRepository;

@Service
public class BusService {
	@Autowired
	BusRepository busRepo;
	
	 public void addBus(Bus bus) {
	        try {
	            // Convert Bus DTO to BusEntity
	        	 BusEntity busEntity = new BusEntity();
	             busEntity.setBusName(bus.getBusName());
	             busEntity.setBusNumber(bus.getBusNumber());
	             busEntity.setBusType(bus.getBusType());
	             busEntity.setFromCity(bus.getFromCity());
	             busEntity.setToCity(bus.getToCity());
	             busEntity.setSeats(bus.getSeats());
	             // You can set other properties as needed

	             // Save the bus to the database
	             busRepo.save(busEntity);
	        } catch (Exception e) {
	            // Handle exceptions appropriately
	            e.printStackTrace();
	            // Throw custom exception or handle the error
	        }
	    }
	 
	 public List<Bus> getAllBuses(){
		 try {
			 List<BusEntity> allBuses = busRepo.findAll();
			 List<Bus> customBuses = new ArrayList<>();
	            allBuses.stream().forEach(b->{
	            	Bus bus = new Bus();
	            	BeanUtils.copyProperties(b, bus);
	            	customBuses.add(bus);
	            });;

	       return customBuses;
		} catch (Exception e) {
			 e.printStackTrace();
	            return null; 
		}
	 }
	public List<Bus> getBuses(String fromCity,String toCity){
		try {
            // Fetch all buses from the database
            List<BusEntity> allBuses = busRepo.findAll();

            // Filter the buses based on the provided cities
            List<BusEntity> filteredBuses = allBuses.stream()
                    .filter(bus -> bus.getFromCity().equalsIgnoreCase(fromCity)
                            && bus.getToCity().equalsIgnoreCase(toCity))
                    .collect(Collectors.toList());

            // Convert BusEntity objects to Bus objects
            List<Bus> customBuses = new ArrayList<>();
            filteredBuses.stream().forEach(b->{
            	Bus bus = new Bus();
            	BeanUtils.copyProperties(b, bus);
            	customBuses.add(bus);
            });;

            return customBuses;
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            return null; // Or throw custom exception
        }
    
	}
}
