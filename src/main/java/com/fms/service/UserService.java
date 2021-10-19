package com.fms.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.fms.model.Users;

public interface UserService {

	public ResponseEntity<?> createUser(Users newUser);

	public Users updateUser(Users newUser);

	public String deleteUser(BigInteger UserId);

	public Iterable<Users> displayAllUser();

	public ResponseEntity<?> findUserById(BigInteger userId);
}