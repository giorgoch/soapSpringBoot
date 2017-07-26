package com.example.demo.endpoints;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.peristence.CityRepository;
import com.giorgoch.playground.schema.cities.City;
import com.giorgoch.playground.schema.cities.GetCityByCodeRequest;
import com.giorgoch.playground.schema.cities.GetCityByCodeResponse;

@Endpoint
public class GetCityByCodeEndpoint {

	static final Logger logger = LogManager.getLogger(GetCityByCodeEndpoint.class.getName());

	CityRepository cityRepository;

	@Autowired
	public GetCityByCodeEndpoint(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@PayloadRoot(namespace = "http://giorgoch.com/playgroud/schema/cities", localPart = "getCityByCodeRequest")
	@ResponsePayload
	public GetCityByCodeResponse getCityByCode(@RequestPayload GetCityByCodeRequest request) {
		logger.info("Entering point");
		GetCityByCodeResponse response = new GetCityByCodeResponse();
		City city = cityRepository.findCity(request.getCode());
		response.setCity(city);
		return response;
	}
}