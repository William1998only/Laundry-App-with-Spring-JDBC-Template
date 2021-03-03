package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.ItemTypes;

/**
 * 
 * @author WILLIAM
 *
 */
public interface ItemTypesService {

	void insertItemType(ItemTypes it) throws Exception;

	List<ItemTypes> getListItemTypes() throws Exception;

	Long getItemTypesByCode(String inputKode);


}
