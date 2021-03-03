package com.lawencon.laundry.dao;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.model.Promos;

/**
 * 
 * @author WILLIAM
 *
 */
public interface PromosDao {

	void insertPromo(Promos p) throws SQLException;

	List<Promos> getListPromo() throws Exception;

}
