package com.lawencon.laundry.view;

import java.util.Scanner;

import com.lawencon.laundry.model.ItemTypes;
import com.lawencon.laundry.service.ItemTypesService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class AddItemTypeView {
	private ItemTypes itemTypes = new ItemTypes();
	private ItemTypesService itemTypesService;
	private Scanner scan = new Scanner(System.in);

	void show(Callback cb) throws Exception {
		System.out.println("===Add Tipe Barang===");
		System.out.print("Tipe barang? ");
		String inputTipe = scan.nextLine();
		System.out.print("Kode barang? ");
		String inputKode = scan.next();
		itemTypes.setItemType(inputTipe);
		itemTypes.setItemCode(inputKode);
		itemTypesService.insertItemType(itemTypes);
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
