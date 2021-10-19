package com.fms.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fms.model.Booking;

@Repository
public interface BookingDao extends CrudRepository<Booking, BigInteger> {

}
