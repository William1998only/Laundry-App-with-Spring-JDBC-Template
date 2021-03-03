package com.lawencon.laundry.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.ItemsDtl;

/**
 * 
 * @author WILLIAM
 *
 */
public class ItemDtlDaoNativeImpl extends BaseDao implements ItemDtlDao {

	@Override
	public void insertItemDtl(Long idInvoiceHdr, ItemsDtl itemsDtl) throws SQLException {
		String sqlBuilder = bBuilder("INSERT INTO t_r_dtl_items ", "(id_hdr_invoice, item_name, id_item_type, ",
				"id_laundry_type, expected_done_date) ",
				"values(?, ?, (select id from t_m_item_types where item_code = ?), ",
				"(select id from t_m_laundry_types where laundry_code = ?), ", "(NOW() + INTERVAL '2 DAY'))")
						.toString();
		getSession().createNativeQuery(sqlBuilder).setParameter(1, idInvoiceHdr).setParameter(2, itemsDtl.getItemName())
				.setParameter(3, itemsDtl.getIdItemType().getItemCode())
				.setParameter(4, itemsDtl.getIdLaundryType().getLaundryCode()).executeUpdate();
	}

	@Override
	public List<ItemsDtl> getAllItemsDtlByCashier(Long idUser) {
		List<ItemsDtl> listResult = new ArrayList<>();
		listResult = getSession().createNativeQuery(bBuilder("select * ", "from t_r_dtl_items di ",
				"inner join t_r_hdr_invoices hi on hi.id = di.id_hdr_invoice ",
				"inner join t_m_users u on u.id = hi.id_user ", "inner join t_m_outlets o on o.id = u.id_outlets ",
				"where o.id = (select id_outlets from t_m_users where id = ?)").toString(), ItemsDtl.class)
				.setParameter(1, idUser).list();
		return listResult;
	}
}
