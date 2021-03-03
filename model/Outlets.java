package com.lawencon.laundry.model;
/**
 * 
 * @author WILLIAM
 *
 */
public class Outlets {
	private Long id;
	private String outletsName;
	private String location;
	private String phoneNumber;
	private String outletsCode;
	public String getOutletsCode() {
		return outletsCode;
	}
	public void setOutletsCode(String outletsCode) {
		this.outletsCode = outletsCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOutletsName() {
		return outletsName;
	}
	public void setOutletsName(String outletsName) {
		this.outletsName = outletsName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
