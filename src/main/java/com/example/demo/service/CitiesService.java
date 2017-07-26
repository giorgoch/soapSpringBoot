package com.example.demo.service;

import com.example.demo.peristence.CityRepository;
import com.giorgoch.playground.schema.cities.City;

public class CitiesService implements ICitiesService {

	CityRepository cityRepository;

	public City getCityByCode(int code) {
		cityRepository = new CityRepository();
		City city = cityRepository.findCity(code);
		return city;
	}

	public String getCountryByCityName(String cityName) {
		cityRepository = new CityRepository();
		String country = cityRepository.findCountry(cityName);
		return country;
	}

}
