package com.example.demo.service;

import com.giorgoch.playground.schema.cities.City;

public interface ICitiesService {

	City getCityByCode(int code);

	String getCountryByCityName(String cityName);

}
