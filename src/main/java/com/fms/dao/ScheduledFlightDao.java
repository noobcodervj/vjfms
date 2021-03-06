package com.fms.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fms.model.ScheduledFlight;

@Repository
public interface ScheduledFlightDao extends CrudRepository<ScheduledFlight, BigInteger>{

}
