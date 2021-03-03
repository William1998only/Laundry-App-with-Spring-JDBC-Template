package com.lawencon.laundry.service;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.dao.InvoicesHdrDao;
import com.lawencon.laundry.model.InvoicesHdr;
import com.lawencon.laundry.model.Promos;

/**
 * 
 * @author WILLIAM
 *
 */
public class InvoicesHdrServiceImpl extends BaseService implements InvoicesHdrService {
	
	private InvoicesHdrDao invoicesHdrDao;
	private ItemDtlService itemDtlService;
	
	public void setInvoicesHdrDao(InvoicesHdrDao invoicesHdrDao) {
		this.invoicesHdrDao = invoicesHdrDao;
	}

	public void setItemDtlService(ItemDtlService itemDtlService) {
		this.itemDtlService = itemDtlService;
	}

	@Override
	public void insertInvoiceHdr(List<InvoicesHdr> iHdr) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			Promos p = new Promos();
			Long idInvoiceHdr = null;
			for(int i = 0; i < iHdr.size(); i++) {
				if(iHdr.get(i).getIdPromo() == null) {
					p.setPromoCode("no_promo");
					iHdr.get(i).setIdPromo(p);
				}
				try {
					idInvoiceHdr = invoicesHdrDao.InsertInvoiceHdr(iHdr.get(i));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					itemDtlService.insertItemDtl(idInvoiceHdr, iHdr.get(i));
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					invoicesHdrDao.updateTotalCost(idInvoiceHdr, iHdr.get(i).getIdPromo().getPromoCode());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public List<InvoicesHdr> getAllInvoiceHdr() throws Exception {
		List<InvoicesHdr> listResult = getTransactionTemplate().execute(val -> {
			try {
				return invoicesHdrDao.getAllInvoiceHdr();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return listResult;
	}

	@Override
	public List<InvoicesHdr> getAllInvoiceHdrByOutletsCode(String inputKodeOutlet) throws Exception {
		List<InvoicesHdr> listResult = getTransactionTemplate().execute(val -> {
			try {
				return invoicesHdrDao.getAllInvoiceHdrByOutletsCode(inputKodeOutlet);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return listResult;
	}

	@Override
	public List<InvoicesHdr> getAllInvoiceHdrByCashier(Long idUser) throws Exception {
		List<InvoicesHdr> listResult = getTransactionTemplate().execute(val -> {
			try {
				return invoicesHdrDao.getAllInvoiceHdrByCashier(idUser);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return listResult;
	}
}
