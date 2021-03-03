package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.dao.PaymentsDao;
import com.lawencon.laundry.model.Payments;

/**
 * 
 * @author WILLIAM
 *
 */
public class PaymentsServiceImpl extends BaseService implements PaymentsService {

	private PaymentsDao paymentsDao;

	public void setPaymentsDao(PaymentsDao paymentsDao) {
		this.paymentsDao = paymentsDao;
	}

	@Override
	public void insertPaymentType(Payments p) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			try {
				paymentsDao.insertPaymentType(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public List<Payments> getPaymentList() throws Exception {
		List<Payments> listResult = getTransactionTemplate().execute(val -> {
			try {
				return paymentsDao.getPaymentList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return listResult;
	}

	@Override
	public int getTotalTransaksi(String paymentType) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return paymentsDao.getTotalTransaksi(paymentType);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
