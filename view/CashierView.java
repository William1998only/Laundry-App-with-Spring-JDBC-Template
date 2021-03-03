package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Users;
import com.lawencon.laundry.service.UsersService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class CashierView extends BaseView {
	private UsersService usersService;
	private Scanner scan = new Scanner(System.in);

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	List<Users> cl = new ArrayList<>();

	void show(Callback cb) throws Exception {
		System.out.println("===View Cashier===");
		System.out.println("1. View all cashier");
		System.out.println("2. Search cashier by username");
		System.out.println("3. Keluar");
		System.out.print("Pilih menu: ");
		byte inputMenu = scan.nextByte();
		if (inputMenu == 1) {
			showAllCashier(scan);
		} else if (inputMenu == 2) {
			searchCashierByUsername(scan);
		} else {
			cb.onDone();
		}
		show(cb);
	}

	private void showAllCashier(Scanner scan) throws Exception {
		cl = usersService.getAllCashier();
		if (cl.size() == 0) {
			validasiDataKosong();
			scan.next();
		} else {
			System.out.println("===Daftar Kasir===");
			System.out.println("No || Username || Outlet");
			for (int i = 0; i < cl.size(); i++) {
				System.out.println(bBuilder(String.valueOf((i + 1)), ". ", cl.get(i).getUserName(), "||",
						cl.get(i).getIdOutlet().getOutletsCode()).toString());
			}
			templateBawahList();
			scan.next();
		}
	}

	private void searchCashierByUsername(Scanner scan2) throws Exception {
		Users c = new Users();
		System.out.print("Username kasir? ");
		String inputUsername = scan.next();
		c = usersService.getCashierByUsername(inputUsername);
		if (c.getIdProfile() == null) {
			System.out.println("Input salah atau data belum ada");
			System.out.println("Masukkan apa saja untuk kembali");
			scan.next();
		} else {
			System.out.println("===Kasir " + c.getIdOutlet().getOutletsCode() + "===");
			System.out.println("Nama: " + c.getIdProfile().getFullName());
			System.out.println("Alamat: " + c.getIdProfile().getAddress());
			System.out.println("No HP: " + c.getIdProfile().getNoHp());
			templateBawahList();
			scan.next();
		}
	}
}
