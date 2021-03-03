package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.LaundryTypes;

/**
 * 
 * @author WILLIAM
 *
 */
public interface LaundryTypesDao {

	void insertLaundryTypes(LaundryTypes lt) throws Exception;

	List<LaundryTypes> getListLaundryTypes() throws Exception;

}
