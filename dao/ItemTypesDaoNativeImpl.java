package com.lawencon.laundry.dao;

import java.util.List;

import com.lawencon.laundry.model.ItemTypes;

/**
 * 
 * @author WILLIAM
 *
 */
public class ItemTypesDaoNativeImpl extends BaseDao implements ItemTypesDao {

	@Override
	public void insertItemType(ItemTypes it) throws Exception {
		String sqlBuilder = bBuilder("INSERT INTO t_m_item_types", "(item_type, item_code) ", "values(?, ?)")
				.toString();
		getSession().createNativeQuery(sqlBuilder).setParameter(1, it.getItemType()).setParameter(2, it.getItemCode())
				.executeUpdate();
	}

	@Override
	public List<ItemTypes> getListItemTypes() throws Exception {
		String sqlBuilder = bBuilder("select * from t_m_item_types ").toString();
		return getSession().createNativeQuery(sqlBuilder, ItemTypes.class).list();
	}

	@Override
	public Long getItemTypesByCode(String inputKode) {
		try {
			String sqlBuilder = bBuilder("select id from t_m_item_types ", "where item_code = ? ").toString();
			Object listObj = getSession().createNativeQuery(sqlBuilder).setParameter(1, inputKode).getSingleResult();
			return Long.valueOf(String.valueOf(listObj));
		} catch (Exception e) {

		}
		return null;
	}

}
