package com.lawencon.laundry.dao;

import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.Payments;

/**
 * 
 * @author WILLIAM
 *
 */
public class PaymentsDaoNativeImpl extends BaseDao implements PaymentsDao {

	@Override
	public void insertPaymentType(Payments p) throws Exception {
		String sqlBuilder = bBuilder("INSERT INTO t_m_payments ", "(payment_type, payment_code) ", "values(?, ?)")
				.toString();
		getSession().createNativeQuery(sqlBuilder).setParameter(1, p.getPaymentType())
				.setParameter(2, p.getPaymentCode()).executeUpdate();
	}

	@Override
	public List<Payments> getPaymentList() throws Exception {
		String sqlBuilder = bBuilder("select * from t_m_payments ").toString();
		return getSession().createNativeQuery(sqlBuilder, Payments.class).list();
	}

	@Override
	public int getTotalTransaksi(String paymentType) throws Exception {
		List<Payments> p = new ArrayList<>();
		String sqlBuilder = bBuilder("select * ", "from t_m_payments p ",
				"inner join t_r_hdr_invoices hi on hi.id_payment = p.id ", "where p.payment_type = ? ").toString();
		p = getSession().createNativeQuery(sqlBuilder, Payments.class).setParameter(1, paymentType).list();
		return p.size();
	}

}
