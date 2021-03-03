package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.LaundryTypes;

/**
 * 
 * @author WILLIAM
 *
 */
public class LaundryTypesDaoNativeImpl extends BaseDao implements LaundryTypesDao {

	@Override
	public void insertLaundryTypes(LaundryTypes lt) throws Exception {
		String sqlBuilder = bBuilder("INSERT INTO t_m_laundry_types", "(laundry_name, laundry_code, service_cost) ",
				"values(?, ?, ?)").toString();
		getSession().createNativeQuery(sqlBuilder).setParameter(1, lt.getLaundryName())
				.setParameter(2, lt.getLaundryCode()).setParameter(3, lt.getLaundryCost()).executeUpdate();
	}

	@Override
	public List<LaundryTypes> getListLaundryTypes() throws Exception {
		String sqlBuilder = bBuilder("select * from t_m_laundry_types ").toString();
		return getSession().createNativeQuery(sqlBuilder, LaundryTypes.class).list();
	}

}
