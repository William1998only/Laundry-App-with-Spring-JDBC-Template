package com.lawencon.laundry.model;
/**
 * 
 * @author WILLIAM
 *
 */
public class Users {
	private Long id;
	private String userName;
	private String password;
	private Roles idRole;
	private ProfileUsers idProfile;
	private Outlets idOutlet;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getIdRole() {
		return idRole;
	}
	public void setIdRole(Roles idRole) {
		this.idRole = idRole;
	}
	public ProfileUsers getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(ProfileUsers idProfile) {
		this.idProfile = idProfile;
	}
	public Outlets getIdOutlet() {
		return idOutlet;
	}
	public void setIdOutlet(Outlets idOutlet) {
		this.idOutlet = idOutlet;
	}
}
