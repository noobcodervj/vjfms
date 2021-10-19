package com.fms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fms.model.Airport;

@Repository
public interface AirportDao extends CrudRepository<Airport, String> {

}
