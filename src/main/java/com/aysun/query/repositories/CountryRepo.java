package com.aysun.query.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aysun.query.models.Cities;
import com.aysun.query.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long>{
	
	List<Country> findAll();
	
	@Query("SELECT c, l FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' "
			+ "ORDER BY l.percentage DESC")
	List<Object[]> findCountriesSpeakingSlovene();
	
	@Query("SELECT c FROM Country c")
	List<Country> findAllCountries();

	@Query("SELECT c, l FROM Country c JOIN c.languages l")
	List<Object[]> joinCountriesAndLanguages();
	
	
	@Query("SELECT c.name FROM Country c JOIN c.languages l WHERE language = ?1 ORDER BY percentage DESC")
	List<Object[]> findCountryWithLanguage(String language);
	
	@Query("SELECT c, count(cities) FROM Country c JOIN c.cities cities GROUP BY c.name "
			+ "ORDER BY count(cities) DESC")
	List<Object[]> findCountriesWithNumCities();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage >= ?1 ORDER BY l.percentage")
	List<Object[]> findLanguagesInAllCountriesOverPercentage(Float percentage);
	
	@Query("SELECT c FROM Country c WHERE c.surface_area < ?1 AND c.population >= ?2")
	List<Country> findCountriesLessThanSizeGreaterThanPopulation(Float size, Long population);
	
	@Query("SELECT c FROM Country c WHERE c.government_form = ?1 AND c.capital > ?2 AND c.life_expectancy < ?3")
	List<Country> findCountriesWithGovtCapitalLifeExpectancy(String govt, Long capital, Float lifeExp);
	
	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY region ORDER BY COUNT(c) DESC")
	List<Object[]> findNumberOfCountriesInRegions();
	
}