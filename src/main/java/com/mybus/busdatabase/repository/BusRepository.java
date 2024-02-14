package com.mybus.busdatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybus.busdatabase.entity.BusEntity;

@Repository
public interface BusRepository extends JpaRepository<BusEntity,Integer> {
	 List<BusEntity> findByFromCityAndToCity(String fromCity, String toCity);

}
