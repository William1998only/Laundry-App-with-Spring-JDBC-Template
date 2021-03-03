package com.lawencon.laundry.dao;


import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;


/**
 * 
 * @author WILLIAM
 *
 */
public abstract class BaseDao {
	
	private DataSource dataSource;
	
	JdbcTemplate jdbcTemplate;
	
	private TransactionTemplate transactionTemplate; 
	private SessionFactory sessionFactory; 

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected StringBuilder bBuilder(String... datas) {
		StringBuilder b = new StringBuilder();
		for (String d : datas) {
			b.append(d);
		}
		return b;
	}
}
