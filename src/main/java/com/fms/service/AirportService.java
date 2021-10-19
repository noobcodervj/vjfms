package com.fms.service;

import org.springframework.http.ResponseEntity;

import com.fms.model.Airport;

public interface AirportService {
	public Iterable<Airport> viewAllAirport();

	public Airport viewAirport(String flightCode);

	public ResponseEntity<?> addAirport(Airport airport);

	public Airport modifyAirport(Airport airport);

	public String removeAirport(String flightCode);
}
