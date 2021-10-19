package com.fms.dao;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import com.fms.model.Users;;

public interface UserDao extends CrudRepository<Users, BigInteger>{

}