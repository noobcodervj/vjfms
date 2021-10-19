package com.fms.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.fms.dao.FlightDao;
import com.fms.model.Flight;
import com.fms.service.FlightServiceImpl;

@ExtendWith(MockitoExtension.class)
class FlightTest {
@Mock
	private FlightDao dao;
@InjectMocks
	private FlightServiceImpl flightService;
BigInteger flightId=BigInteger.valueOf(1L);
	@Test
	void viewAllFlightTest() {

	List<Flight> list = new ArrayList<Flight>();
	Flight flight = new Flight(flightId,"SpiceJet","v777",200);
	list.add(flight);
	
	when(dao.findAll()).thenReturn(list);
	List<Flight> flightList = (List<Flight>) flightService.viewAllFlight();
	assertEquals(1,flightList.size());
	}
	
	@Test
	void saveFlightTest() {
		Flight flight= new Flight(flightId,"SpiceJet","v777",200);
		when(dao.save(flight)).thenReturn(flight);
		ResponseEntity<Flight> savedFlight = flightService.addFlight(flight);
		assertThat(savedFlight).isNotNull();
	
	}
}