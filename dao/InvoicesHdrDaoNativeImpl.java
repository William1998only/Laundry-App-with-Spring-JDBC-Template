package com.lawencon.laundry.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.InvoicesHdr;

/**
 * 
 * @author WILLIAM
 *
 */
public class InvoicesHdrDaoNativeImpl extends BaseDao implements InvoicesHdrDao {

	@Override
	public Long InsertInvoiceHdr(InvoicesHdr invoicesHdr) throws SQLException {
		String sqlBuilder = bBuilder("INSERT INTO t_r_hdr_invoices ", "(id_customer, id_user, total_cost,",
				"order_date, invoice_code, id_payment, id_promo) ",
				"values((select id from t_m_customers where nik = ?), ", "(select id from t_m_users where id = ?), ",
				"0, now(), ('TR' || ((select count(*) from t_r_hdr_invoices) + 1)), ",
				"(select id from t_m_payments where payment_code = ?),",
				" (select id from t_m_promos where promo_code = ?)) returning id").toString();
		Object listObj = getSession().createNativeQuery(sqlBuilder)
				.setParameter(1, invoicesHdr.getIdCustomer().getNIK()).setParameter(2, invoicesHdr.getIdUser().getId())
				.setParameter(3, invoicesHdr.getIdPayment().getPaymentCode())
				.setParameter(4, invoicesHdr.getIdPromo().getPromoCode()).getSingleResult();
		return Long.valueOf(String.valueOf(listObj));
	}

	@Override
	public void updateTotalCost(Long idInvoiceHdr, String kodePromo) throws SQLException {
		String sqlBuilder = bBuilder("update t_r_hdr_invoices ", "set total_cost = (select sum(lt.service_cost) ",
				"from t_r_dtl_items d ", "inner join t_m_laundry_types lt on lt.id = d.id_laundry_type ",
				"where d.id_hdr_invoice = ?) - ", "(select discount from t_m_promos ", "where promo_code = ?)",
				"where id = ?").toString();
		getSession().createNativeQuery(sqlBuilder).setParameter(1, idInvoiceHdr).setParameter(2, kodePromo)
				.setParameter(3, idInvoiceHdr).executeUpdate();
	}

	@Override
	public List<InvoicesHdr> getAllInvoiceHdr() throws Exception {
		List<InvoicesHdr> listResult = new ArrayList<>();
		listResult = getSession().createNativeQuery(bBuilder("select hi.* ", "from t_r_hdr_invoices hi ",
				"inner join t_r_dtl_items di on di.id_hdr_invoice = hi.id ",
				"inner join t_m_users u on u.id = hi.id_user ", "inner join t_m_outlets o on o.id = u.id_outlets ",
				"group by hi.id ", "order by hi.order_date asc").toString(), // sama dengan INNER JOIN universitas as u
																				// on u.id = m.universitas_id
				InvoicesHdr.class).list();
		return listResult;
	}

	@Override
	public List<InvoicesHdr> getAllInvoiceHdrByOutletsCode(String inputKodeOutlet) throws Exception {
		List<InvoicesHdr> listResult = new ArrayList<>();
		listResult = getSession().createNativeQuery(bBuilder("select hi.* ", "from t_r_hdr_invoices hi ",
				"inner join t_r_dtl_items di on di.id_hdr_invoice = hi.id ",
				"inner join t_m_users u on u.id = hi.id_user ", "inner join t_m_outlets o on o.id = u.id_outlets ",
				"where o.outlet_code = ?", "group by hi.id ", "order by hi.order_date asc").toString(), // sama dengan
																										// //
																										// m.universitas_id
				InvoicesHdr.class).setParameter(1, inputKodeOutlet).list();
		return listResult;
	}

	@Override
	public List<InvoicesHdr> getAllInvoiceHdrByCashier(Long idUser) throws Exception {
		List<InvoicesHdr> listResult = new ArrayList<>();
		listResult = getSession().createNativeQuery(bBuilder("select hi.* ", "from t_r_hdr_invoices hi ",
				"inner join t_r_dtl_items di on di.id_hdr_invoice = hi.id ",
				"inner join t_m_users u on u.id = hi.id_user ", "inner join t_m_customers c on c.id = hi.id_customer ",
				"inner join t_m_promos p on p.id = hi.id_promo ", "inner join t_m_outlets o on o.id = u.id_outlets ",
				"inner join t_m_payments pay on pay.id = hi.id_payment ",
				"where u.id_outlets = (select id_outlets from t_m_users", " where id = ?) ", "group by hi.id ",
				"order by hi.order_date asc").toString(), InvoicesHdr.class).setParameter(1, idUser).list();
		return listResult;
	}

}
