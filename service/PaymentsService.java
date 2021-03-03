package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.model.Payments;

/**
 * 
 * @author WILLIAM
 *
 */
public interface PaymentsService {

	void insertPaymentType(Payments p) throws Exception;

	List<Payments> getPaymentList() throws Exception;

	int getTotalTransaksi(String paymentType) throws Exception;

}
