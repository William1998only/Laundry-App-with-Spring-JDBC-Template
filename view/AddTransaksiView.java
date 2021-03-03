package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Customers;
import com.lawencon.laundry.model.InvoicesHdr;
import com.lawencon.laundry.model.ItemTypes;
import com.lawencon.laundry.model.ItemsDtl;
import com.lawencon.laundry.model.LaundryTypes;
import com.lawencon.laundry.model.Payments;
import com.lawencon.laundry.model.Promos;
import com.lawencon.laundry.model.UserSessionCache;
import com.lawencon.laundry.model.Users;
import com.lawencon.laundry.service.InvoicesHdrService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class AddTransaksiView {
	private List<InvoicesHdr> iHdr = new ArrayList<>();
	private Scanner scan = new Scanner(System.in);
	private InvoicesHdrService invoicesHdrService;
	private UserSessionCache activeUser;
	
	public void setActiveUser(UserSessionCache activeUser) {
		this.activeUser = activeUser;
	}

	public void setInvoicesHdrService(InvoicesHdrService invoicesHdrService) {
		this.invoicesHdrService = invoicesHdrService;
	}

	void show(Callback cb) throws Exception {
		System.out.println("===Add Transaksi===");
		System.out.print("Nomor KTP? ");
		String inputNoKtp = scan.next();
		Customers c = new Customers();
		c.setNIK(inputNoKtp);
		InvoicesHdr invoices = new InvoicesHdr();
		invoices.setIdCustomer(c);
		System.out.print("Kode payment? ");
		String inputKodePayment = scan.next();
		Payments p = new Payments();
		p.setPaymentCode(inputKodePayment);
		invoices.setIdPayment(p);
		System.out.print("input promo? [Y/N]");
		String inputPilih = scan.next();
		if(inputPilih.equalsIgnoreCase("Y")) {
			System.out.print("Kode promo? ");
			String inputKodePromo = scan.next();
			Promos promo = new Promos();
			promo.setPromoCode(inputKodePromo);
			invoices.setIdPromo(promo);
		}
		Users u = new Users();
		u.setId(activeUser.getActiveUser().getId());
		invoices.setIdUser(u);
		List<ItemsDtl> itemDtl = new ArrayList<>();
		while(true) {
			System.out.print("Input nama barang: ");
			scan.nextLine();
			String inputNamaBarang = scan.nextLine();
			ItemsDtl i = new ItemsDtl();
			i.setItemName(inputNamaBarang);
			System.out.print("Input kode servis: ");
			String inputKodeServis = scan.next();
			LaundryTypes lt = new LaundryTypes();
			lt.setLaundryCode(inputKodeServis);
			i.setIdLaundryType(lt);
			System.out.print("Input tipe barang: ");
			String inputTipeBarang = scan.next();
			ItemTypes it = new ItemTypes();
			it.setItemCode(inputTipeBarang);
			i.setIdItemType(it);
			itemDtl.add(i);
			System.out.print("Mau menambahkan barang lagi? Y/N");
			String inputMenu = scan.next();
			if(!inputMenu.equalsIgnoreCase("y")){
				invoices.setItems(itemDtl);
				iHdr.add(invoices);
				break;
			}
		}
		System.out.print("Mau menambahkan data lagi? Y/N");
		String inputMenu = scan.next();
		if(!inputMenu.equalsIgnoreCase("y")) {
			invoicesHdrService.insertInvoiceHdr(iHdr);
			iHdr.clear();
			cb.onDone();
		}else {
			show(cb);
		}
	}
}
