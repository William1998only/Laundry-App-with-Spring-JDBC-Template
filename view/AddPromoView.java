package com.lawencon.laundry.view;

import java.math.BigDecimal;
import java.util.Scanner;

import com.lawencon.laundry.model.Promos;
import com.lawencon.laundry.service.PromosService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class AddPromoView {
	private Promos promos = new Promos();
	private PromosService promosService;
	private Scanner scan = new Scanner(System.in);

	public void setPromosService(PromosService promosService) {
		this.promosService = promosService;
	}

	void show(Callback cb) throws Exception {
		System.out.println("===Add Promo===");
		System.out.print("Nama promo? ");
		String inputNama = scan.nextLine();
		System.out.print("Kode promo? ");
		String inputPromo = scan.next();
		System.out.print("Jumlah potongan? ");
		int inputPotongan = scan.nextInt();
		promos.setPromoName(inputNama);
		promos.setPromoCode(inputPromo);
		promos.setDiscount(BigDecimal.valueOf(inputPotongan));
		promosService.insertPromo(promos);
		scan.nextLine();
		cb.onDone();
	}
}
