package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Promos;

/**
 * 
 * @author WILLIAM
 *
 */
public interface PromosService {

	void insertPromo(Promos p) throws Exception;

	List<Promos> getListPromo() throws Exception;

}
