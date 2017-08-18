package com.aysun.query.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aysun.query.models.Cities;
import com.aysun.query.models.Country;
import com.aysun.query.services.ApiService;

@Controller
public class Main {
	
	private final ApiService apiService;
	
	public Main(ApiService apiService) {
		this.apiService = apiService;
	}

	@RequestMapping("/")
	public String index(Model model) {
////----------------------------1. Countries with language Slovene, arranged by language percent(desc) --------------------------------------------------------------		
		List<Object[]> sloveneCountries = apiService.findCountriesSpeakingSlovene();
		model.addAttribute("sloveneCountries", sloveneCountries);
////----------------------------2. Name of countries and total number of cities ordered by number of cities(desc)----------------------------------------------------

		List<Object[]> cityCountByCountry = apiService.findCountriesWithNumCities();
		model.addAttribute("cityCountByCountry", cityCountByCountry);
		
////------------3. All the cities in Mexico with a population of greater than 500,000 oredered by Population(desc)----------------------------------------------------
//		
//		
		List<Cities> cityMexico = apiService.findCitiesInCountryWithPopulation("mexico", 500000L);
		model.addAttribute("cityMexico", cityMexico);
		
////-----------4. Get all languages in each country with a percentage greater than 89% ordered by Percentage(desc)----------------------------------------------------

		
		List<Object[]> languagesByCountry = apiService.findLanguagesInAllCountriesOverPercentage(89F);
		model.addAttribute("languagesByCountry", languagesByCountry);
		
////-----------5. all the countries with Surface Area below 501 and Population greater than 100,000----------------------------------------------------

		List<Country> smallCountries = apiService.findCountriesLessThanSizeGreaterThanPopulation(501F, 100000L);
		model.addAttribute("smallCountries", smallCountries);

////-----------6. Get countries with only Constitutional Monarchy with a capital greater than 200 and a life expectancy greater than 75 years----------------------------------------------------

		List<Country> govMonarchy = apiService.findCountriesWithGovtCapitalLifeExpentancy("constitutional monarchy", 200L, 75F);
		model.addAttribute("govMonarchy", govMonarchy);

////----------7. Get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500,000----------------------------------------------------		

		List<Cities> buenosAiresCities = apiService.findBuenosAiresCities();
		model.addAttribute("buenosAiresCities", buenosAiresCities);
		
////----------8. Summarize the number of countries in each region--------------------------------------------------------------------------------------------------
	

		List<Object[]> numberCountries = apiService.findNumberOfCountriesInRegions();
		model.addAttribute("numberCountries", numberCountries);
		
		
		return "NewFile.jsp";
	}
}