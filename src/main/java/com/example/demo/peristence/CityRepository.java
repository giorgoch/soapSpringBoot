package com.example.demo.peristence;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.giorgoch.playground.schema.cities.City;

@Component
public class CityRepository {

	static final Logger logger = LogManager.getLogger(CityRepository.class.getName());

	private static final List<City> cities = new ArrayList<City>();

	@PostConstruct
	public void initData() {
		City neuruppin = new City();
		neuruppin.setName("Neuruppin");
		neuruppin.setCountry("Germany");
		neuruppin.setCode(16816);
		neuruppin.setPopulation(30000);
		neuruppin.setFounded(1256);
		cities.add(neuruppin);

		City paris = new City();
		paris.setName("Paris");
		paris.setCountry("France");
		paris.setCode(75001);
		paris.setPopulation(2250000);
		paris.setFounded(1256);
		cities.add(paris);
	}

	public City findCity(int code) {
		logger.info("searching city for: " + code);
		City result = null;
		for (City city : cities) {
			if (code == city.getCode()) {
				result = city;
			}
		}
		return result;
	}

	public String findCountry(String cityName) {
		logger.info("searching country for: " + cityName);
		String result = null;
		for (City city : cities) {
			if (cityName.equals(city.getName())) {
				result = city.getCountry();
			}
		}
		return result;
	}

}
