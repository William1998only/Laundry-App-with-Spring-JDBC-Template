package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Users;

/**
 * 
 * @author WILLIAM
 *
 */
public interface UsersService {

	Users getUserByPassword(String inputUsername, String inputPassword) throws Exception;

	void insertCashier(Users u) throws Exception;

	List<Users> getAllCashier() throws Exception;

	Users getCashierByUsername(String inputUsername) throws Exception;

}
