package com.lawencon.laundry.constant;
/**
 * 
 * @author WILLIAM
 *
 */
public enum RoleCode {
	ADMIN(1), KASIR(2);
	
	public int roleCode;
	
	RoleCode(int roleCode){
		this.roleCode = roleCode;
	}
}
