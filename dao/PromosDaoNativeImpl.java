package com.lawencon.laundry.dao;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.model.Promos;

/**
 * 
 * @author WILLIAM
 *
 */
public class PromosDaoNativeImpl extends BaseDao implements PromosDao {

	@Override
	public void insertPromo(Promos p) throws SQLException {
		String sqlBuilder = bBuilder("INSERT INTO t_m_promos ", "(promo_name, promo_code, discount) ",
				"values(?, ?, ?)").toString();
		getSession().createNativeQuery(sqlBuilder).setParameter(1, p.getPromoName()).setParameter(2, p.getPromoCode())
				.setParameter(3, p.getDiscount()).executeUpdate();
	}

	@Override
	public List<Promos> getListPromo() throws Exception {
		String sqlBuilder = bBuilder("select * from t_m_promos ", "where promo_name != 'no_promo'").toString();
		return getSession().createNativeQuery(sqlBuilder, Promos.class).list();
	}

}
