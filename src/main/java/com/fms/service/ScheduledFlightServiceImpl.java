package com.fms.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fms.model.Schedule;
import com.fms.model.Booking;
import com.fms.exceptions.RecordNotFoundException;
import com.fms.exceptions.ScheduledFlightNotFoundException;
import com.fms.dao.ScheduleDao;
import com.fms.dao.ScheduledFlightDao;
import com.fms.model.ScheduledFlight;

@Service
public class ScheduledFlightServiceImpl implements ScheduledFlightService {

	/*
	 * Creating DAO object
	 */
	@Autowired
	ScheduledFlightDao dao;

	@Autowired
	ScheduleDao scheduleDao;

	@Autowired
	BookingService bookingService;

	/*
	 * Service method to add new Scheduled flight to database
	 */
	@Override
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
		return dao.save(scheduledFlight);
	}

	/*
	 * Service method to modify existing Scheduled flight in database
	 */
	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduleFlight) {
		return dao.save(scheduleFlight);
	}

	/*
	 * Service method to remove existing Scheduled flight from database
	 */
	@Override
	public String removeScheduledFlight(BigInteger flightId) throws RecordNotFoundException {
		if (flightId == null)
			throw new RecordNotFoundException("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new RecordNotFoundException("Enter a valid Flight Id");
		else {
			// try {
			// cancelBookings(flightId);
			// } catch (RecordNotFoundException e) {
			// System.out.println("No Bookings Found");
			// }
			dao.deleteById(flightId);
		}
		return "Scheduled flight with ID " + flightId + " is not found";
	}

	// @Override
	// public boolean cancelBookings(BigInteger flightId) throws
	// RecordNotFoundException {
	// Iterable<Booking> bookingList = bookingService.displayAllBooking();
	// for (Booking booking : bookingList) {
	// if (booking.getScheduleFlight().getScheduleFlightId().equals(flightId)) {
	// bookingService.deleteBooking(booking.getBookingId());
	// }
	// }
	// return true;
	// }

	/*
	 * Service method to view all Scheduled flights in database
	 */
	@Override
	public Iterable<ScheduledFlight> viewAllScheduledFlights() {
		return dao.findAll();
	}

	/*
	 * Service method to view a Scheduled flight by ID from database
	 */
	@Override
	public ScheduledFlight viewScheduledFlight(BigInteger flightId) throws ScheduledFlightNotFoundException {
		if (flightId == null)
			throw new ScheduledFlightNotFoundException("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new ScheduledFlightNotFoundException("Enter a valid Flight Id");
		else
			return scheduleFlight.get();
	}

}
