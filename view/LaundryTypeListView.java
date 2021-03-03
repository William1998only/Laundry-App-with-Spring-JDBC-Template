package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.LaundryTypes;
import com.lawencon.laundry.service.LaundryTypesService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class LaundryTypeListView extends BaseView {
	private List<LaundryTypes> lt = new ArrayList<>();
	private LaundryTypesService laundryTypesService;
	private Scanner scan = new Scanner(System.in);

	public void setLaundryTypesService(LaundryTypesService laundryTypesService) {
		this.laundryTypesService = laundryTypesService;
	}

	void show(Callback cb) throws Exception {

		lt = laundryTypesService.getListLaundryTypes();
		if (lt.size() == 0) {
			validasiDataKosong();
			scan.next();
		} else {
			System.out.println("===Daftar Tipe Laundry===");
			System.out.println("No || Nama Laundry || Kode || Harga");
			for (int i = 0; i < lt.size(); i++) {
				System.out.println(bBuilder(String.valueOf((i + 1)), ". ", lt.get(i).getLaundryName(), "||",
						lt.get(i).getLaundryCode(), "||", String.valueOf(lt.get(i).getLaundryCost())).toString());
			}
			templateBawahList();
			scan.next();
		}
		cb.onDone();
	}
}
