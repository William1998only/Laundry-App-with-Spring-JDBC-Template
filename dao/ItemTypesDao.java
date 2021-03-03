package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.ItemTypes;

/**
 * 
 * @author WILLIAM
 *
 */
public interface ItemTypesDao {

	void insertItemType(ItemTypes it) throws Exception;

	List<ItemTypes> getListItemTypes() throws Exception;

	Long getItemTypesByCode(String inputKode);

}
