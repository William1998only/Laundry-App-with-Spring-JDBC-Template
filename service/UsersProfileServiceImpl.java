package com.lawencon.laundry.service;

import java.sql.SQLException;

import com.lawencon.laundry.dao.UsersProfileDao;
import com.lawencon.laundry.model.Users;

/**
 * 
 * @author WILLIAM
 *
 */
public class UsersProfileServiceImpl extends BaseService implements UsersProfileService {

	private UsersProfileDao usersProfileDao;

	public void setUsersProfileDao(UsersProfileDao usersProfileDao) {
		this.usersProfileDao = usersProfileDao;
	}

	@Override
	public Long insertProfile(Users user) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return usersProfileDao.insertProfile(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
