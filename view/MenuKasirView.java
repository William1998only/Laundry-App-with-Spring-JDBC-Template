package com.lawencon.laundry.view;

import java.util.Scanner;

import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class MenuKasirView {
	private Scanner scan = new Scanner(System.in);
	private AddTransaksiView addTransaksiView;
	private AddPromoView addPromoView;
	private AddPaymentTypeView addPaymentTypeView;
	private AddItemTypeView addItemTypeView;
	private AddLaundryTypeView addLaundryTypeView;
	private TransaksiByOutletView transaksiByOutletView;
	private PromoListView promoListView;
	private PaymentListView paymentListView;
	private ItemTypeListView itemTypeListView;
	private LaundryTypeListView laundryTypeListView;
	private DetailItemListView detailItemListView;
	
	public void setDetailItemListView(DetailItemListView detailItemListView) {
		this.detailItemListView = detailItemListView;
	}

	public void setAddTransaksiView(AddTransaksiView addTransaksiView) {
		this.addTransaksiView = addTransaksiView;
	}

	public void setAddPromoView(AddPromoView addPromoView) {
		this.addPromoView = addPromoView;
	}

	public void setAddPaymentTypeView(AddPaymentTypeView addPaymentTypeView) {
		this.addPaymentTypeView = addPaymentTypeView;
	}

	public void setAddItemTypeView(AddItemTypeView addItemTypeView) {
		this.addItemTypeView = addItemTypeView;
	}

	public void setAddLaundryTypeView(AddLaundryTypeView addLaundryTypeView) {
		this.addLaundryTypeView = addLaundryTypeView;
	}

	public void setTransaksiByOutletView(TransaksiByOutletView transaksiByOutletView) {
		this.transaksiByOutletView = transaksiByOutletView;
	}

	public void setPromoListView(PromoListView promoListView) {
		this.promoListView = promoListView;
	}

	public void setPaymentListView(PaymentListView paymentListView) {
		this.paymentListView = paymentListView;
	}

	public void setItemTypeListView(ItemTypeListView itemTypeListView) {
		this.itemTypeListView = itemTypeListView;
	}

	public void setLaundryTypeListView(LaundryTypeListView laundryTypeListView) {
		this.laundryTypeListView = laundryTypeListView;
	}

	public void show(Callback cb) throws Exception{
		System.out.println("===Menu Kasir===");
		System.out.println("1. Add Transaksi");
		System.out.println("2, Add Promo");
		System.out.println("3. Add Payment Type");
		System.out.println("4. Add Item Type");
		System.out.println("5. Add Laundry Type");
		System.out.println("6. View List Transaksi");
		System.out.println("7. View Detail item");
		System.out.println("8. View List Promo");
		System.out.println("9. View List Payment");
		System.out.println("10. View List Item Type");
		System.out.println("11. View List Laundry");
		System.out.println("12. Keluar");
		System.out.print("Pilih menu: ");
		byte inputMenu = scan.nextByte();
		switch(inputMenu)
		{
			case 1:
				addTransaksiView.show(() ->
						show(cb));
			case 2:
				addPromoView.show(() ->
						show(cb));
			case 3:
				addPaymentTypeView.show(() ->
						show(cb));
			case 4:
				addItemTypeView.show(() ->
						show(cb));
			case 5:
				addLaundryTypeView.show(() ->
						show(cb));
			case 6:
				transaksiByOutletView.show(() ->
						show(cb));
			case 7:
				detailItemListView.show(() ->
						show(cb));
			case 8: 
				promoListView.show(() ->
						show(cb));
			case 9:
				paymentListView.show(() ->
						show(cb));
			case 10:
				itemTypeListView.show(() ->
						show(cb));
			case 11:
				laundryTypeListView.show(() ->
						show(cb));
		}
		cb.onDone();
	}
}
