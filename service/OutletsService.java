package com.lawencon.laundry.service;


import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.model.Outlets;

/**
 * 
 * @author WILLIAM
 *
 */
public interface OutletsService {

	void insertOutletsData(Outlets o) throws Exception;

	Long getOutletsByCode(String outletsCode) throws SQLException;

	List<Outlets> getAllOutlets() throws Exception;

	Outlets searchOutletsByCode(String inputKode) throws Exception;
}
