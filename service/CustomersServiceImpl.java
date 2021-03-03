package com.lawencon.laundry.service;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.dao.CustomersDao;
import com.lawencon.laundry.model.Customers;

/**
 * 
 * @author WILLIAM
 *
 */
public class CustomersServiceImpl extends BaseService implements CustomersService {

	private CustomersDao customersDao;

	public void setCustomersDao(CustomersDao customersDao) {
		this.customersDao = customersDao;
	}

	@Override
	public void insertCustomer(Customers c) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				customersDao.insertCustomer(c);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public List<Customers> getAllCustomer() throws Exception {
		List<Customers> listResult = getTransactionTemplate().execute(val -> {
			try {
				return customersDao.getAllCustomer();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return listResult;
	}

	@Override
	public Long getCustomerbyNik(String inputNoKtp) {
		return getTransactionTemplate().execute(val -> {
			try {
				return customersDao.getCustomerbyNik(inputNoKtp);
			} catch (Exception e) {

			}
			return null;
		});
	}

}
