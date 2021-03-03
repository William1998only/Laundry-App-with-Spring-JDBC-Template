package com.lawencon.laundry.dao;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.model.Customers;

/**
 * 
 * @author WILLIAM
 *
 */
public class CustomersDaoNativeImpl extends BaseDao implements CustomersDao {

	@Override
	public void insertCustomer(Customers c) throws SQLException {
		String sqlBuilder = bBuilder("INSERT INTO t_m_customers ", "(name, address, phone_number, nik) ",
				"values(?, ?, ?, ?)").toString();
		getSession().createNativeQuery(sqlBuilder).setParameter(1, c.getName()).setParameter(2, c.getAddress())
				.setParameter(3, c.getPhoneNumber()).setParameter(4, c.getNIK()).executeUpdate();
	}

	@Override
	public List<Customers> getAllCustomer() throws Exception {
		return getSession().createNativeQuery("SELECT * FROM t_m_customers", Customers.class).list();
	}

	@Override
	public Long getCustomerbyNik(String inputNoKtp) {
		try {
			String sqlBuilder = bBuilder("select id from t_m_customers ", "where nik = ? ").toString();
			Object listObj = getSession().createNativeQuery(sqlBuilder).setParameter(1, inputNoKtp).getSingleResult();
			return Long.valueOf(String.valueOf(listObj));
		} catch (Exception e) {

		}
		return null;
	}

}
