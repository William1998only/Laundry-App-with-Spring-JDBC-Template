package com.lawencon.laundry.view;

import java.util.Scanner;

import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class MenuAdminView {
	private Scanner scan = new Scanner(System.in);
	private AddOutletView addOutletView;
	private AddCashierView addCashierView;
	private AddCustomerView addCustomerView;
	private TransaksiAllOutletView transaksiAllOutletView;
	private OutletView outletView;
	private CashierView cashierView;
	private CustomerView customerView;
	
	public void setAddOutletView(AddOutletView addOutletView) {
		this.addOutletView = addOutletView;
	}

	public void setAddCashierView(AddCashierView addCashierView) {
		this.addCashierView = addCashierView;
	}

	public void setAddCustomerView(AddCustomerView addCustomerView) {
		this.addCustomerView = addCustomerView;
	}

	public void setTransaksiAllOutletView(TransaksiAllOutletView transaksiAllOutletView) {
		this.transaksiAllOutletView = transaksiAllOutletView;
	}

	public void setOutletView(OutletView outletView) {
		this.outletView = outletView;
	}

	public void setCashierView(CashierView cashierView) {
		this.cashierView = cashierView;
	}

	public void setCustomerView(CustomerView customerView) {
		this.customerView = customerView;
	}

	public void show(Callback cb) throws Exception{
		System.out.println("===Menu Admin===");
		System.out.println("1. Add Outlet");
		System.out.println("2. Add Kasir");
		System.out.println("3. Add Customer");
		System.out.println("4. View Transaksi all Outlet");
		System.out.println("5. View Outlet");
		System.out.println("6. View Kasir");
		System.out.println("7. View customer");
		System.out.println("8. Keluar");
		System.out.print("Pilih menu: ");
		byte inputMenu = scan.nextByte();
		switch(inputMenu)
		{
			case 1:
				addOutletView.show(() ->
						show(cb));
			case 2:
				addCashierView.show(() ->
						show(cb));
			case 3:
				addCustomerView.show(() ->
						show(cb));
			case 4:
				transaksiAllOutletView.show(() ->
						show(cb));
			case 5:
				outletView.show(() ->
						show(cb));
			case 6:
				cashierView.show(() ->
						show(cb));
			case 7:
				customerView.show(() ->
						show(cb));
		}
		cb.onDone();
	}
}
