package com.lawencon.laundry.view;

import java.util.Scanner;

import com.lawencon.laundry.model.Payments;
import com.lawencon.laundry.service.PaymentsService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class AddPaymentTypeView {
	private Payments payments = new Payments();
	private PaymentsService paymentsService;
	private Scanner scan = new Scanner(System.in);

	public void setPaymentsService(PaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}

	void show(Callback cb) throws Exception {
		System.out.println("===Add Payment Type===");
		System.out.print("Nama Payment? ");
		String inputNama = scan.nextLine();
		System.out.print("Kode Payment? ");
		String inputKode = scan.next();
		payments.setPaymentType(inputNama);
		payments.setPaymentCode(inputKode);
		paymentsService.insertPaymentType(payments);
		scan.nextLine();
		cb.onDone();
	}
}
