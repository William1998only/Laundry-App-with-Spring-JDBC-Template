package com.lawencon.laundry.model;

import java.math.BigDecimal;

/**
 * 
 * @author WILLIAM
 *
 */
public class LaundryTypes {
	private Long id;
	private String laundryName;
	private String laundryCode;
	private BigDecimal laundryCost;
	public BigDecimal getLaundryCost() {
		return laundryCost;
	}
	public void setLaundryCost(BigDecimal laundryCost) {
		this.laundryCost = laundryCost;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLaundryName() {
		return laundryName;
	}
	public void setLaundryName(String laundryName) {
		this.laundryName = laundryName;
	}
	public String getLaundryCode() {
		return laundryCode;
	}
	public void setLaundryCode(String laundryCode) {
		this.laundryCode = laundryCode;
	}
}
