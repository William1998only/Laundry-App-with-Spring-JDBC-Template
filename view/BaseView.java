package com.lawencon.laundry.view;
/**
 * 
 * @author WILLIAM
 *
 */
public abstract class BaseView {
	protected StringBuilder bBuilder(String... datas) {
		StringBuilder b = new StringBuilder();
		for (String d : datas) {
			b.append(d);
		}
		return b;
	}
	protected void validasiDataKosong() {
		System.out.println("Data belum ada");
		System.out.println("Masukkan apa saja untuk kembali");
	}
	protected void templateBawahList() {
		System.out.println("");
		System.out.println("Masukkan apa saja untuk kembali");
	}
}
