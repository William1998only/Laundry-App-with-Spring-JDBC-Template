package com.lawencon.laundry.view;

import java.util.Scanner;

import com.lawencon.laundry.constant.RoleCode;
import com.lawencon.laundry.model.UserSessionCache;
import com.lawencon.laundry.service.UsersService;

/**
 * 
 * @author WILLIAM
 *
 */
public class MainView {
	private Scanner scan = new Scanner(System.in);
	private UsersService usersService;
	private MenuAdminView menuAdminView;
	private MenuKasirView menuKasirView;
	private UserSessionCache activeUser;
	
	public void setActiveUser(UserSessionCache activeUser) {
		this.activeUser = activeUser;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public void setMenuAdminView(MenuAdminView menuAdminView) {
		this.menuAdminView = menuAdminView;
	}

	public void setMenuKasirView(MenuKasirView menuKasirView) {
		this.menuKasirView = menuKasirView;
	}

	public void showMenuUtama() throws Exception{
		System.out.println("===SELAMAT DATANG===");
		System.out.print("Username : ");
		String inputUsername = scan.next();
		System.out.print("Password : ");
		String inputPassword = scan.next();
		if(null != usersService.getUserByPassword(inputUsername, inputPassword)&& null != usersService.getUserByPassword(inputUsername, inputPassword)) {
			activeUser.setActiveUser(usersService.getUserByPassword(inputUsername, inputPassword));
			if(activeUser.getActiveUser().getIdRole().getRoleCode() == RoleCode.ADMIN.roleCode) {
				menuAdminView.show(() ->
						{
							try {
								showMenuUtama();
							} catch (Exception e) {
								e.printStackTrace();
							}
						});
			}else if(activeUser.getActiveUser().getIdRole().getRoleCode() == RoleCode.KASIR.roleCode) {
				menuKasirView.show(() ->
						{
							try {
								showMenuUtama();
							} catch (Exception e) {
								e.printStackTrace();
							}
						});
			}else {
				showMenuUtama();
			}
		}else {
			System.out.println("Username atau password salah");
			System.out.println("Masukkan apa saja untuk kembali");
			scan.next();
			showMenuUtama();
		}
	}
}
