package com.aysun.query.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aysun.query.models.*;

@Repository
public interface CityRepo extends CrudRepository<Cities, Long>{

	@Query("SELECT ci FROM Cities ci JOIN ci.country c WHERE c.name = ?1 AND ci.population >= ?2 ORDER BY ci.population DESC")
	List<Cities> findCitiesInCountryWithPopulation(String country, Long population);
	
	@Query("SELECT  c.name, ci.name, ci.district, ci.population FROM Cities ci JOIN ci.country c WHERE c.name = ?1 AND ci.district = ?2 AND ci.population > ?3 ")
	List<Object[]> findCitiesInCountryInDistrictWithPopulation(String country, String city, Long population);
	
	@Query("SELECT c.name, ci.name, ci.district, ci.population from Country c, Cities ci WHERE c.name = 'Argentina' AND ci.district = 'Buenos Aires' AND ci.population > 500000 ORDER BY ci.population DESC")
	List<Cities> findBuenosAiresCities();
	
}