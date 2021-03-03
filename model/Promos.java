package com.lawencon.laundry.model;

import java.math.BigDecimal;

/**
 * 
 * @author WILLIAM
 *
 */
public class Promos {
	private Long id;
	private String promoName;
	private String promoCode;
	private BigDecimal discount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPromoName() {
		return promoName;
	}
	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
}	
