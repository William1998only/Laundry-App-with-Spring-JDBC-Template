package com.lawencon.laundry.dao;

import java.sql.SQLException;
import java.util.List;

import com.lawencon.laundry.model.InvoicesHdr;

/**
 * 
 * @author WILLIAM
 *
 */
public interface InvoicesHdrDao {
	
	Long InsertInvoiceHdr(InvoicesHdr invoicesHdr) throws SQLException;

	void updateTotalCost(Long idInvoiceHdr, String kodePromo) throws SQLException;

	List<InvoicesHdr> getAllInvoiceHdr() throws Exception;

	List<InvoicesHdr> getAllInvoiceHdrByOutletsCode(String inputKodeOutlet) throws Exception;

	List<InvoicesHdr> getAllInvoiceHdrByCashier(Long idUser) throws Exception;

}
