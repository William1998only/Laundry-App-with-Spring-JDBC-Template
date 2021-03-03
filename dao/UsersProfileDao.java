package com.lawencon.laundry.dao;

import java.sql.SQLException;

import com.lawencon.laundry.model.Users;

/**
 * 
 * @author WILLIAM
 *
 */
public interface UsersProfileDao {

	Long insertProfile(Users user) throws SQLException;

}
