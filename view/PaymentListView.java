package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Payments;
import com.lawencon.laundry.service.PaymentsService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class PaymentListView extends BaseView{
	private PaymentsService paymentsService;
	private Scanner scan = new Scanner(System.in);
	
	public void setPaymentsService(PaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}
	
	private List<Payments> p = new ArrayList<>();
	void show(Callback cb) throws Exception {
		
		p = paymentsService.getPaymentList();
		if(p.size() == 0) {
			validasiDataKosong();
			scan.next();
		}else {
			System.out.println("===Daftar Payment===");
			System.out.println("No || Nama || Kode || Jumlah Transaksi");
			for(int i = 0; i < p.size(); i++) {
				System.out.println(bBuilder(String.valueOf((i+1)),
				"||", p.get(i).getPaymentType(), "||", p.get(i).getPaymentCode()		
				,"||", String.valueOf(paymentsService.getTotalTransaksi(p.get(i).getPaymentType()))
				).toString());
			}
			templateBawahList();
			scan.next();
		}
		cb.onDone();
	}
}
