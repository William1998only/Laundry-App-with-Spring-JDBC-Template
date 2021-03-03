package com.lawencon.laundry.view;

import java.util.Scanner;

import com.lawencon.laundry.model.Outlets;
import com.lawencon.laundry.model.ProfileUsers;
import com.lawencon.laundry.model.Users;
import com.lawencon.laundry.service.OutletsService;
import com.lawencon.laundry.service.UsersService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class AddCashierView{
	private ProfileUsers p = new ProfileUsers();
	private Users u = new Users();
	private Outlets o = new Outlets();
	private Scanner scan = new Scanner(System.in);
	private UsersService usersService;
	private OutletsService outletsService;
	
	public void setOutletsService(OutletsService outletsService) {
		this.outletsService = outletsService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	void show(Callback cb) throws Exception{
		System.out.println("===Add Cashier===");
		System.out.print("Nama lengkap? ");
		String inputNama = scan.nextLine();
		System.out.print("Alamat? ");
		String inputAlamat = scan.nextLine();
		System.out.print("No HP? ");
		String inputNoHp = scan.next();
		System.out.print("Username? ");
		String inputUsername = scan.next();
		Users findUser = usersService.getCashierByUsername(inputUsername);
		while(null != findUser) {
			System.out.println("Username sudah ada");
			System.out.print("Username? ");
			inputUsername = scan.next();
			findUser = usersService.getCashierByUsername(inputUsername);
		}
		System.out.print("Password? ");
		String inputPassword = scan.next();
		System.out.print("Kode outlet? ");
		String inputKodeOutlet = scan.next();
		Long findOutlet = outletsService.getOutletsByCode(inputKodeOutlet);
		while(findOutlet == null) {
			System.out.println("Input Kode Salah");
			System.out.print("Kode outlet? ");
			inputKodeOutlet = scan.next();
			findOutlet = outletsService.getOutletsByCode(inputKodeOutlet);
		}
		p.setFullName(inputNama);
		p.setAddress(inputAlamat);
		p.setNoHp(inputNoHp);
		u.setIdProfile(p);
		o.setOutletsCode(inputKodeOutlet);
		u.setIdOutlet(o);
		u.setUserName(inputUsername);
		u.setPassword(inputPassword);
		usersService.insertCashier(u);
		scan.nextLine();
		cb.onDone();
	}
}
