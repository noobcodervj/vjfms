package com.fms.service;

import com.fms.service.AirportService;
import java.math.BigInteger;
import java.util.Optional;

import com.fms.model.Airport;
import com.fms.model.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fms.exceptions.RecordNotFoundException;
import com.fms.dao.AirportDao;
import com.fms.exceptions.RecordAlreadyPresentException;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	AirportDao airportDao;

	/*
	 * view all Airports
	 */
	@Override
	public Iterable<Airport> viewAllAirport() {
		return airportDao.findAll();
	}

	/*
	 * view airport by flightCode
	 */
	@Override
	public Airport viewAirport(String flightCode) {
		Optional<Airport> findById = airportDao.findById(flightCode);
		if (findById.isPresent()) {
			return findById.get();
		}
			
			//return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
		else
			throw new RecordNotFoundException("Airport with airport code: " + flightCode + "not exists");
	    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
        }*/

	/*
	 * add a airport
	 */
	@Override
	public ResponseEntity<?> addAirport(Airport airport) {
		Optional<Airport> findById = airportDao.findById(airport.getFlightCode());
		try {
		if (!findById.isPresent()) {
			airportDao.save(airport);
			return new ResponseEntity<Airport>(airport,HttpStatus.OK);
		} 
		else
			throw new RecordAlreadyPresentException(
					"Flight with code : " + airport.getFlightCode() + " already present");
	     }
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<Airport>(airport,HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * modify an Airport
	 */
	@Override
	public Airport modifyAirport(Airport airport) {
		Optional<Airport> findById = airportDao.findById(airport.getFlightCode());
		if (findById.isPresent()) {
			airportDao.save(airport);
		} 
		else
			throw new RecordNotFoundException("Airport with code: " + airport.getFlightCode() + " not exists");
		return airport;
	}

	/*
	 * remove an airport
	 */
	@Override
	public String removeAirport(String flightCode) {
		Optional<Airport> findById = airportDao.findById(flightCode);
		if (findById.isPresent()) {
			airportDao.deleteById(flightCode);
			return "Airport removed";
		} else
			throw new RecordNotFoundException("Airport with code: " + flightCode + " not exists");

	}
}
