package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Customers;

/**
 * 
 * @author WILLIAM
 *
 */
public interface CustomersService {

	void insertCustomer(Customers c) throws Exception;

	List<Customers> getAllCustomer() throws Exception;

	Long getCustomerbyNik(String inputNoKtp);

}
