package com.lawencon.laundry.service;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.dao.PromosDao;
import com.lawencon.laundry.model.Promos;

/**
 * 
 * @author WILLIAM
 *
 */
public class PromosServiceImpl extends BaseService implements PromosService {

	private PromosDao promosDao;

	public void setPromosDao(PromosDao promosDao) {
		this.promosDao = promosDao;
	}

	@Override
	public void insertPromo(Promos p) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				promosDao.insertPromo(p);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public List<Promos> getListPromo() throws Exception {
		List<Promos> listResult = getTransactionTemplate().execute(val -> {
			try {
				return promosDao.getListPromo();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return listResult;
	}

}
