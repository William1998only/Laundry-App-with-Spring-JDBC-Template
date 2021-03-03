package com.lawencon.laundry.service;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.dao.OutletsDao;
import com.lawencon.laundry.model.Outlets;

/**
 * 
 * @author WILLIAM
 *
 */
public class OutletsServiceImpl extends BaseService implements OutletsService {

	private OutletsDao outletsDao;

	public void setOutletsDao(OutletsDao outletsDao) {
		this.outletsDao = outletsDao;
	}

	@Override
	public void insertOutletsData(Outlets o) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				outletsDao.insertOutletsData(o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public Long getOutletsByCode(String outletsCode) throws SQLException {
		return getTransactionTemplate().execute(val -> {
			try {
				return outletsDao.getOutletsByCode(outletsCode);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public List<Outlets> getAllOutlets() throws Exception {
		List<Outlets> listResult = getTransactionTemplate().execute(val -> {
			try {
				return outletsDao.getAllOutlets();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return listResult;
	}

	@Override
	public Outlets searchOutletsByCode(String inputKode) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return outletsDao.searchOutletsByCode(inputKode);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
