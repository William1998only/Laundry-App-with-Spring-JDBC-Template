package com.lawencon.laundry.model;
/**
 * 
 * @author WILLIAM
 *
 */
public class ItemTypes {
	private Long id;
	private String itemType;
	private String itemCode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
}
