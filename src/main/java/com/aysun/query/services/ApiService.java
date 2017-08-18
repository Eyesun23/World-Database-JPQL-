package com.aysun.query.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aysun.query.models.Cities;
import com.aysun.query.models.Country;
import com.aysun.query.models.Language;
import com.aysun.query.repositories.CityRepo;
import com.aysun.query.repositories.CountryRepo;
import com.aysun.query.repositories.LanguageRepo;

@Service
public class ApiService {

	private CountryRepo countryRepo;
	private LanguageRepo languageRepo;
	private CityRepo cityRepo;
	
	public ApiService(CountryRepo countryRepo, LanguageRepo languageRepo, 
			CityRepo cityRepo) {
		this.countryRepo = countryRepo;
		this.languageRepo = languageRepo;
		this.cityRepo = cityRepo;
	}
	
	public List<Country> findAllCountries() {
		List<Country> countries = countryRepo.findAllCountries();	
		return countries;
	}
	
	public List<Object[]> joinCountriesAndLanguages(){
		return countryRepo.joinCountriesAndLanguages();
	}
	
	public List<Object[]> findCountriesWithNumCities(){
		return countryRepo.findCountriesWithNumCities();
	}
	
	public List<Cities> findCitiesInCountryWithPopulation(String country, Long population){
		return cityRepo.findCitiesInCountryWithPopulation(country, population);
	}
	
	
	public List<Object[]> findLanguagesInAllCountriesOverPercentage(Float percentage){
		return countryRepo.findLanguagesInAllCountriesOverPercentage(percentage);
	}
	
	public List<Country> findCountriesLessThanSizeGreaterThanPopulation(Float size, Long population){
		return countryRepo.findCountriesLessThanSizeGreaterThanPopulation(size, population);
	}
	
	public List<Country> findCountriesWithGovtCapitalLifeExpentancy(String govt, Long capital, Float lifeExp){
		return countryRepo.findCountriesWithGovtCapitalLifeExpectancy(govt, capital, lifeExp);
	}
	
	public List<Object[]> findCitiesInCountryInDistrictWithPopulation(String country, String city, Long population){
		return cityRepo.findCitiesInCountryInDistrictWithPopulation(country, city, population);
	}
	
	public List<Object[]> findNumberOfCountriesInRegions(){
		return countryRepo.findNumberOfCountriesInRegions();
	}
	
	public List<Language> findAllLanguagesNames(){
		return languageRepo.findAllLanguagesNames();
	}
	
	public List<Cities> findBuenosAiresCities() {
		return cityRepo.findBuenosAiresCities();
	}

	public List<Object[]> findCountriesSpeakingSlovene() {
		return countryRepo.findCountriesSpeakingSlovene();
	}
	
}