package com.fms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport
/**
 * Class Airport
 */
{
	@Id
	private String flightCode;
	private String airportLocation;
	private String airportName;

	public Airport(String airportName, String airportLocation, String airportCode)
	/**
	 * parameterized Constructor
	 */
	{
		this.airportName = airportName;
		this.airportLocation = airportLocation;
		this.flightCode = airportCode;
	}

	public Airport()
	/**
	 * Unparameterized Constructor
	 */
	{
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	@Override
	public String toString() {
		return "Airport{" + "airportName='" + airportName + '\'' + ", airportLocation='" + airportLocation + '\''
				+ ", flightCode='" + flightCode + '\'' + '}';
	}
}
