package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.dao.LaundryTypesDao;
import com.lawencon.laundry.model.LaundryTypes;

/**
 * 
 * @author WILLIAM
 *
 */
public class LaundryTypesServiceImpl extends BaseService implements LaundryTypesService {

	private LaundryTypesDao laundryTypesDao;

	public void setLaundryTypesDao(LaundryTypesDao laundryTypesDao) {
		this.laundryTypesDao = laundryTypesDao;
	}

	@Override
	public void insertLaundryTypes(LaundryTypes lt) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				laundryTypesDao.insertLaundryTypes(lt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public List<LaundryTypes> getListLaundryTypes() throws Exception {
		List<LaundryTypes> listResult = getTransactionTemplate().execute(val -> {
			try {
				return laundryTypesDao.getListLaundryTypes();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return listResult;
	}

}
