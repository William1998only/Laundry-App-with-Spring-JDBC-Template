package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.ItemsDtl;
import com.lawencon.laundry.model.UserSessionCache;
import com.lawencon.laundry.service.ItemDtlService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class DetailItemListView extends BaseView {
	private ItemDtlService itemDtlService;
	private List<ItemsDtl> ih = new ArrayList<>();
	private Scanner scan = new Scanner(System.in);
	private UserSessionCache activeUser;

	public void setActiveUser(UserSessionCache activeUser) {
		this.activeUser = activeUser;
	}

	public void setItemDtlService(ItemDtlService itemDtlService) {
		this.itemDtlService = itemDtlService;
	}

	void show(Callback cb) throws Exception {
		ih = itemDtlService.getAllItemsDtlByCashier(activeUser.getActiveUser().getId());
		if (ih.size() == 0) {
			validasiDataKosong();
			scan.next();
		} else {
			System.out.println("===Daftar Barang===");
			System.out.println(
					bBuilder("No || Nama Barang || Tanggal Selesai", " || Tipe Barang || Tipe Laundry || Harga")
							.toString());
			for (int i = 0; i < ih.size(); i++) {
				System.out.println(bBuilder(String.valueOf((i + 1)), "||", ih.get(i).getItemName(), "||",
						String.valueOf(ih.get(i).getExpectedDoneDate()), "||", ih.get(i).getIdItemType().getItemType(),
						"||", ih.get(i).getIdLaundryType().getLaundryName(), "||",
						String.valueOf(ih.get(i).getIdLaundryType().getLaundryCost())).toString());
			}
			templateBawahList();
			scan.next();
		}
		cb.onDone();
	}
}