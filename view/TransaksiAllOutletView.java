package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.InvoicesHdr;
import com.lawencon.laundry.service.InvoicesHdrService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class TransaksiAllOutletView extends BaseView {
	private Scanner scan = new Scanner(System.in);
	private InvoicesHdrService invoicesHdrService;

	public void setInvoicesHdrService(InvoicesHdrService invoicesHdrService) {
		this.invoicesHdrService = invoicesHdrService;
	}

	private List<InvoicesHdr> il = new ArrayList<>();

	void show(Callback cb) throws Exception {
		System.out.println("===View Transaksi===");
		System.out.println("1. View all transaksi");
		System.out.println("2. Search transaksi by outlet");
		System.out.println("3. Keluar");
		System.out.print("Pilih menu: ");
		byte inputMenu = scan.nextByte();
		if (inputMenu == 1) {
			showAllTransaksi(scan);
		} else if (inputMenu == 2) {
			showAllTransaksiByOutletCode(scan);
		} else {
			cb.onDone();
		}
		show(cb);
	}

	private void showAllTransaksi(Scanner scan) throws Exception {
		il = invoicesHdrService.getAllInvoiceHdr();
		if (il.size() == 0) {
			validasiDataKosong();
			scan.next();
		} else {
			System.out.println("===Daftar Transaksi===");
			System.out.println("No || Tanggal Order || Biaya || Kasir || Cabang");
			il = invoicesHdrService.getAllInvoiceHdr();
			for (int i = 0; i < il.size(); i++) {
				System.out.println(bBuilder(String.valueOf((i + 1)), ". ", String.valueOf(il.get(i).getOrderDate()),
						"||", "||", String.valueOf(il.get(i).getTotalCost()), "||", il.get(i).getIdUser().getUserName(),
						"||", il.get(i).getIdUser().getIdOutlet().getOutletsCode()).toString());
			}
			templateBawahList();
			scan.next();
		}
	}

	private void showAllTransaksiByOutletCode(Scanner scan) throws Exception {
		System.out.print("Kode Cabang? ");
		String inputKodeOutlet = scan.next();
		il = invoicesHdrService.getAllInvoiceHdrByOutletsCode(inputKodeOutlet);
		if (il.size() == 0) {
			System.out.println("Belum ada data atau kode salah");
			System.out.println("Masukkan apa saja untuk kembali");
			scan.next();
		} else {
			System.out.println("===Daftar Transaksi===");
			System.out.println("No || Tanggal Order || Biaya || Kasir");
			for (int i = 0; i < il.size(); i++) {
				System.out.println(bBuilder(String.valueOf((i + 1)), ". ", String.valueOf(il.get(i).getOrderDate()),
						"||", String.valueOf(il.get(i).getTotalCost()), "||", il.get(i).getIdUser().getUserName())
								.toString());
			}
			templateBawahList();
			scan.next();
		}
	}
}
