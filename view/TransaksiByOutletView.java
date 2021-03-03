package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.InvoicesHdr;
import com.lawencon.laundry.model.UserSessionCache;
import com.lawencon.laundry.service.InvoicesHdrService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class TransaksiByOutletView extends BaseView{
	private InvoicesHdrService invoicesHdrService;
	private List<InvoicesHdr> ih = new ArrayList<>();
	private Scanner scan = new Scanner(System.in);
	private UserSessionCache activeUser;
	
	public void setActiveUser(UserSessionCache activeUser) {
		this.activeUser = activeUser;
	}

	public void setInvoicesHdrService(InvoicesHdrService invoicesHdrService) {
		this.invoicesHdrService = invoicesHdrService;
	}
	
	void show(Callback cb) throws Exception {
		ih = invoicesHdrService.getAllInvoiceHdrByCashier(activeUser.getActiveUser().getId());
		if(ih.size() == 0) {
			validasiDataKosong();
			scan.next();
		}else {
			System.out.println("Daftar Transaksi " + ih.get(0).getIdUser().getIdOutlet().getOutletsCode());
			System.out.println(bBuilder("No || Nama Cust || Tanggal Order"
					," || Total Biaya || Pembayaran || Promo"
					).toString());
			for(int i = 0; i < ih.size(); i++) {
				System.out.println(bBuilder(String.valueOf((i+1)), "||",
				ih.get(i).getIdCustomer().getName(), "||", 
				String.valueOf(ih.get(i).getOrderDate()), "||",
				String.valueOf(ih.get(i).getTotalCost()), "||",
				ih.get(i).getIdPayment().getPaymentType(), "||",
				ih.get(i).getIdPromo().getPromoName()).toString());
			}
			templateBawahList();
			scan.next();
		}
		cb.onDone();
	}
}