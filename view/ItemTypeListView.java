package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.ItemTypes;
import com.lawencon.laundry.service.ItemTypesService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class ItemTypeListView extends BaseView {
	private ItemTypesService itemTypesService;
	private Scanner scan = new Scanner(System.in);

	public void setItemTypesService(ItemTypesService itemTypesService) {
		this.itemTypesService = itemTypesService;
	}

	private List<ItemTypes> it = new ArrayList<>();

	void show(Callback cb) throws Exception {

		it = itemTypesService.getListItemTypes();
		if (it.size() == 0) {
			validasiDataKosong();
			scan.next();
		} else {
			System.out.println("===Daftar Tipe Barang===");
			System.out.println("No || Tipe Item || Kode Item");
			for (int i = 0; i < it.size(); i++) {
				System.out.println(
						bBuilder(String.valueOf((i + 1)), ". ", it.get(i).getItemType(), "||", it.get(i).getItemCode())
								.toString());
			}
			templateBawahList();
			scan.next();
		}
		cb.onDone();
	}
}
