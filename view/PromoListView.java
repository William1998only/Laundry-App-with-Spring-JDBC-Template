package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Promos;
import com.lawencon.laundry.service.PromosService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class PromoListView extends BaseView{
	private PromosService promosService;
	private Scanner scan = new Scanner(System.in);
	
	public void setPromosService(PromosService promosService) {
		this.promosService = promosService;
	}
	private List<Promos> p = new ArrayList<>();
	void show(Callback cb) throws Exception {
		p = promosService.getListPromo();
		if(p.size() == 0) {
			validasiDataKosong();
			scan.next();
		}else {
			System.out.println("===Daftar Promo===");
			System.out.println("No || Nama Promo || Kode Promo || Diskon");
			for(int i = 0; i < p.size(); i++) {
				System.out.println(bBuilder(String.valueOf((i+1)), ". ",
				p.get(i).getPromoName(), "||", p.get(i).getPromoCode(), "||",
				String.valueOf(p.get(i).getDiscount())).toString());
			}
			templateBawahList();
			scan.next();
		}
		cb.onDone();
	}
}	
