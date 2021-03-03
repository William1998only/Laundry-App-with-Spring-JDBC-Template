package com.lawencon.laundry.dao;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.model.Customers;

/**
 * 
 * @author WILLIAM
 *
 */
public interface CustomersDao {

	void insertCustomer(Customers c) throws SQLException;

	List<Customers> getAllCustomer() throws Exception;

	Long getCustomerbyNik(String inputNoKtp);

}
