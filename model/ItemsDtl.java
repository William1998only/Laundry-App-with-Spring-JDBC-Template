package com.lawencon.laundry.model;

import java.time.LocalDate;

/**
 * 
 * @author WILLIAM
 *
 */
public class ItemsDtl {
	private Long id;
	private InvoicesHdr idInvoice;
	private String itemName;
	private ItemTypes idItemType;
	private LaundryTypes idLaundryType;
	private LocalDate expectedDoneDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public InvoicesHdr getIdInvoice() {
		return idInvoice;
	}
	public void setIdInvoice(InvoicesHdr idInvoice) {
		this.idInvoice = idInvoice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public ItemTypes getIdItemType() {
		return idItemType;
	}
	public void setIdItemType(ItemTypes idItemType) {
		this.idItemType = idItemType;
	}
	public LaundryTypes getIdLaundryType() {
		return idLaundryType;
	}
	public void setIdLaundryType(LaundryTypes idLaundryType) {
		this.idLaundryType = idLaundryType;
	}
	public LocalDate getExpectedDoneDate() {
		return expectedDoneDate;
	}
	public void setExpectedDoneDate(LocalDate expectedDoneDate) {
		this.expectedDoneDate = expectedDoneDate;
	}
}
