package com.lawencon.laundry.dao;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.model.ItemsDtl;

/**
 * 
 * @author WILLIAM
 *
 */
public interface ItemDtlDao {

	void insertItemDtl(Long idInvoiceHdr, ItemsDtl itemsDtl) throws SQLException;

	List<ItemsDtl> getAllItemsDtlByCashier(Long idUser);

}
