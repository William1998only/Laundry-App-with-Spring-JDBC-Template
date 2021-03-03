package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.LaundryTypes;

/**
 * 
 * @author WILLIAM
 *
 */
public interface LaundryTypesService {

	void insertLaundryTypes(LaundryTypes lt) throws Exception;

	List<LaundryTypes> getListLaundryTypes() throws Exception;

}
