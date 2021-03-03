package com.lawencon.laundry.service;

import org.springframework.transaction.support.TransactionTemplate;

/**
 * 
 * @author WILLIAM
 *
 */
public abstract class BaseService {
	private TransactionTemplate transactionTemplate;

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
	
}
