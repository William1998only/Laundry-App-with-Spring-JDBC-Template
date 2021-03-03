package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Outlets;
import com.lawencon.laundry.service.OutletsService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class OutletView extends BaseView {
	private Scanner scan = new Scanner(System.in);
	private OutletsService outletsService;

	public void setOutletsService(OutletsService outletsService) {
		this.outletsService = outletsService;
	}

	void show(Callback cb) throws Exception {
		System.out.println("===View Outlets===");
		System.out.println("1. View all outlets");
		System.out.println("2. Search outlet by code");
		System.out.println("3. Keluar");
		System.out.print("Pilih menu: ");
		byte inputMenu = scan.nextByte();
		if (inputMenu == 1) {
			showAllOutlet(scan);
		} else if (inputMenu == 2) {
			showAllTransaksiByOutletCode(scan);
		} else {
			cb.onDone();
		}
		show(cb);
	}

	private void showAllOutlet(Scanner scan) throws Exception {
		List<Outlets> ol = new ArrayList<>();
		ol = outletsService.getAllOutlets();
		if (ol.size() == 0) {
			System.out.println("Belum ada data");
			System.out.println("Masukkan apa saja untuk kembali");
			scan.next();
		} else {
			System.out.println("===Daftar Outlets");
			System.out.println("No || Nama || Lokasi || No Telp || Kode");
			for (int i = 0; i < ol.size(); i++) {
				System.out.println(bBuilder(String.valueOf((i + 1)), ". ", ol.get(i).getOutletsName(), "||",
						ol.get(i).getLocation(), "||", ol.get(i).getPhoneNumber(), "||", ol.get(i).getOutletsCode())
								.toString());
			}
			System.out.println("");
			System.out.println("Masukkan apa saja untuk kembali");
			scan.next();
		}
	}

	private void showAllTransaksiByOutletCode(Scanner scan) throws Exception {
		System.out.print("Kode outlet? ");
		String inputKode = scan.next();
		Outlets o = new Outlets();
		o = outletsService.searchOutletsByCode(inputKode);
		if (o.getOutletsName() == null) {
			System.out.println("Belum ada data atau input salah");
			System.out.println("Masukkan apa saja untuk kembali");
			scan.next();
		} else {
			System.out.println("===Outlet " + inputKode + "===");
			System.out.println("Nama outlet : " + o.getOutletsName());
			System.out.println("Lokasi outlet : " + o.getLocation());
			System.out.println("Nomor telepon : " + o.getPhoneNumber());
			System.out.println("");
			System.out.println("Masukkan apa saja untuk kembali");
			scan.next();
		}
	}
}
