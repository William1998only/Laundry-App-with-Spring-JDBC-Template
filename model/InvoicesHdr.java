package com.lawencon.laundry.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


/**
 * 
 * @author WILLIAM
 *
 */
public class InvoicesHdr {
	private Long id;
	private Customers idCustomer;
	private Users idUser;
	private BigDecimal totalCost;
	private LocalDate orderDate;
	private String invoiceCode;
	private Payments idPayment;
	private Promos idPromo;
	private ItemsDtl idItem;
	private List<ItemsDtl> items;
	public ItemsDtl getIdItem() {
		return idItem;
	}
	public void setIdItem(ItemsDtl idItem) {
		this.idItem = idItem;
	}
	public List<ItemsDtl> getItems() {
		return items;
	}
	public void setItems(List<ItemsDtl> items) {
		this.items = items;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customers getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Customers idCustomer) {
		this.idCustomer = idCustomer;
	}
	public Users getIdUser() {
		return idUser;
	}
	public void setIdUser(Users idUser) {
		this.idUser = idUser;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	public Payments getIdPayment() {
		return idPayment;
	}
	public void setIdPayment(Payments idPayment) {
		this.idPayment = idPayment;
	}
	public Promos getIdPromo() {
		return idPromo;
	}
	public void setIdPromo(Promos idPromo) {
		this.idPromo = idPromo;
	}
}
