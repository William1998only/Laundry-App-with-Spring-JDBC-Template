package com.lawencon.laundry.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.Outlets;

/**
 * 
 * @author WILLIAM
 *
 */
public class OutletsDaoNativeImpl extends BaseDao implements OutletsDao {

	@Override
	public void insertOutletsData(Outlets o) throws Exception {
		String sqlBuilder = bBuilder("INSERT INTO t_m_outlets ", "(outlets_name, location, phone_number, outlet_code) ",
				"values(?, ?, ?, ?)").toString();
		getSession().createNativeQuery(sqlBuilder).setParameter(1, o.getOutletsName()).setParameter(2, o.getLocation())
				.setParameter(3, o.getPhoneNumber()).setParameter(4, o.getOutletsCode()).executeUpdate();
	}

	@Override
	public Long getOutletsByCode(String outletsCode) throws SQLException {
		try {
			String sqlBuilder = bBuilder("select id from t_m_outlets ", "where outlet_code = ? ").toString();
			Object listObj = getSession().createNativeQuery(sqlBuilder).setParameter(1, outletsCode).getSingleResult();
			return Long.valueOf(String.valueOf(listObj));
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public List<Outlets> getAllOutlets() throws Exception {
		String sqlBuilder = bBuilder("select * from t_m_outlets").toString();
		return getSession().createNativeQuery(sqlBuilder, Outlets.class).list();
	}

	@Override
	public Outlets searchOutletsByCode(String inputKode) throws Exception {
		String sqlBuilder = bBuilder("select * from t_m_outlets ", "where outlet_code = ? ").toString();
		List<Outlets> ol = new ArrayList<>();
		ol = getSession().createNativeQuery(sqlBuilder, Outlets.class).setParameter(1, inputKode).list();
		return ol.get(0);
	}

}
