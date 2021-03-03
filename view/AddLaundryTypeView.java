package com.lawencon.laundry.view;

import java.math.BigDecimal;
import java.util.Scanner;

import com.lawencon.laundry.model.LaundryTypes;
import com.lawencon.laundry.service.LaundryTypesService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class AddLaundryTypeView {
	private LaundryTypes laundryTypes = new LaundryTypes();
	private LaundryTypesService laundryTypesService;
	private Scanner scan = new Scanner(System.in);

	public void setLaundryTypesService(LaundryTypesService laundryTypesService) {
		this.laundryTypesService = laundryTypesService;
	}

	void show(Callback cb) throws Exception {
		System.out.println("===Add Laundry Type===");
		System.out.print("Nama Laundry? ");
		String inputNama = scan.nextLine();
		System.out.print("Kode Laundry? ");
		String inputKode = scan.next();
		System.out.print("Harga? ");
		int inputHarga = scan.nextInt();
		laundryTypes.setLaundryName(inputNama);
		laundryTypes.setLaundryCode(inputKode);
		laundryTypes.setLaundryCost(BigDecimal.valueOf(inputHarga));
		laundryTypesService.insertLaundryTypes(laundryTypes);
		System.out.print("Tambah data lagi? [Y/N] ");
		String input = scan.next();
		if (input.equalsIgnoreCase("Y")) {
			scan.nextLine();
			show(cb);
		} else {
			scan.nextLine();
			cb.onDone();
		}
	}
}
