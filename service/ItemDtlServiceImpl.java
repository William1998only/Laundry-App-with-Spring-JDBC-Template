package com.lawencon.laundry.service;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.dao.ItemDtlDao;
import com.lawencon.laundry.model.InvoicesHdr;
import com.lawencon.laundry.model.ItemsDtl;

/**
 * 
 * @author WILLIAM
 *
 */
public class ItemDtlServiceImpl extends BaseService implements ItemDtlService {

	private ItemDtlDao itemDtlDao;

	public void setItemDtlDao(ItemDtlDao itemDtlDao) {
		this.itemDtlDao = itemDtlDao;
	}

	@Override
	public void insertItemDtl(Long idInvoiceHdr, InvoicesHdr invoicesHdr) throws Exception {
		for (int i = 0; i < invoicesHdr.getItems().size(); i++) {
			try {
				itemDtlDao.insertItemDtl(idInvoiceHdr, invoicesHdr.getItems().get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<ItemsDtl> getAllItemsDtlByCashier(Long idUser) {
		List<ItemsDtl> listResult = getTransactionTemplate().execute(val -> {
			return itemDtlDao.getAllItemsDtlByCashier(idUser);
		});
		return listResult;
	}

}
