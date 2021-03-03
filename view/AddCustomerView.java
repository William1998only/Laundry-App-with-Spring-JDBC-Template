package com.lawencon.laundry.view;

import java.util.Scanner;

import com.lawencon.laundry.model.Customers;
import com.lawencon.laundry.service.CustomersService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class AddCustomerView {
	private Customers customers = new Customers();
	private CustomersService customersService;
	private Scanner scan = new Scanner(System.in);

	public void setCustomersService(CustomersService customersService) {
		this.customersService = customersService;
	}

	void show(Callback cb) throws Exception {

		System.out.println("===Add Customer");
		System.out.print("Nama lengkap? ");
		String inputNama = scan.nextLine();
		System.out.print("Alamat? ");
		String inputAlamat = scan.nextLine();
		System.out.print("Nomor telepon? ");
		String inputNoTelp = scan.next();
		System.out.print("NIK? ");
		String inputNoKtp = scan.next();
		Long findCustomer = customersService.getCustomerbyNik(inputNoKtp);
		while (findCustomer != null) {
			System.out.println("Data sudah ada");
			System.out.print("NIK? ");
			inputNoKtp = scan.next();
			findCustomer = customersService.getCustomerbyNik(inputNoKtp);
		}
		customers.setName(inputNama);
		customers.setAddress(inputAlamat);
		customers.setPhoneNumber(inputNoTelp);
		customers.setNIK(inputNoKtp);
		customersService.insertCustomer(customers);
		System.out.println("Data berhasil dimasukkan");
		System.out.println("Masukkan apa saja untuk kembali");
		scan.nextLine();
		cb.onDone();
	}
}
