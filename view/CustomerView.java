package com.lawencon.laundry.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lawencon.laundry.model.Customers;
import com.lawencon.laundry.service.CustomersService;
import com.lawencon.laundry.util.Callback;

/**
 * 
 * @author WILLIAM
 *
 */
public class CustomerView extends BaseView {
	private CustomersService customersService;
	Scanner scan = new Scanner(System.in);

	public void setCustomersService(CustomersService customersService) {
		this.customersService = customersService;
	}

	void show(Callback cb) throws Exception {

		List<Customers> c = new ArrayList<>();
		c = customersService.getAllCustomer();
		if (c.size() == 0) {
			validasiDataKosong();
			scan.next();
		} else {
			System.out.println("===Daftar Customer===");
			System.out.println("No || Nama || Alamat || No Telepon || NIK");
			for (int i = 0; i < c.size(); i++) {
				System.out.println(bBuilder(String.valueOf((i + 1)), ". ", c.get(i).getName(), "||",
						c.get(i).getAddress(), "||", c.get(i).getPhoneNumber(), "||", c.get(i).getNIK()).toString());
			}
			templateBawahList();
			scan.next();
		}
		cb.onDone();
	}
}
