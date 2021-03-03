package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.dao.ItemTypesDao;
import com.lawencon.laundry.model.ItemTypes;

/**
 * 
 * @author WILLIAM
 *
 */
public class ItemTypesServiceImpl extends BaseService implements ItemTypesService {

	private ItemTypesDao itemTypesDao;

	public void setItemTypesDao(ItemTypesDao itemTypesDao) {
		this.itemTypesDao = itemTypesDao;
	}

	@Override
	public void insertItemType(ItemTypes it) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				itemTypesDao.insertItemType(it);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public List<ItemTypes> getListItemTypes() throws Exception {
		List<ItemTypes> listResult = getTransactionTemplate().execute(val -> {
			try {
				return itemTypesDao.getListItemTypes();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return listResult;
	}

	@Override
	public Long getItemTypesByCode(String inputKode) {
		return getTransactionTemplate().execute(val -> {
			try {
				return itemTypesDao.getItemTypesByCode(inputKode);
			} catch (Exception e) {

			}
			return null;
		});
	}

}
