package com.lawencon.laundry.view;

import java.util.Scanner;

import com.lawencon.laundry.model.Outlets;
import com.lawencon.laundry.service.OutletsService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class AddOutletView {

	private OutletsService outletsService;
	private Outlets outlets = new Outlets();
	private Scanner scan = new Scanner(System.in);

	public void setOutletsService(OutletsService outletsService) {
		this.outletsService = outletsService;
	}

	void show(Callback cb) throws Exception {
		System.out.println("===Add Outlet===");
		System.out.print("Nama outlet? ");
		String inputNama = scan.nextLine();
		System.out.print("Alamat? ");
		String inputAlamat = scan.nextLine();
		System.out.print("Kode outlet? ");
		String inputKodeOutlet = scan.next();
		System.out.print("Nomor telepon? ");
		String inputNomorTelp = scan.next();
		outlets.setOutletsName(inputNama);
		outlets.setLocation(inputAlamat);
		outlets.setOutletsCode(inputKodeOutlet);
		outlets.setPhoneNumber(inputNomorTelp);
		outletsService.insertOutletsData(outlets);
		scan.nextLine();
		cb.onDone();
	}
}
