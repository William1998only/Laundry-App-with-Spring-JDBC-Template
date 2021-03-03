package com.lawencon.laundry.dao;

import java.sql.SQLException;

import com.lawencon.laundry.model.Users;

/**
 * 
 * @author WILLIAM
 *
 */
public class UsersProfileDaoNativeImpl extends BaseDao implements UsersProfileDao {

	@Override
	public Long insertProfile(Users user) throws SQLException {
		String sqlBuilder = bBuilder("INSERT INTO t_m_profile_users ", "(fullname, address, no_hp) ",
				"values(?, ?, ?) returning id").toString();
		Object result = getSession().createNativeQuery(sqlBuilder).setParameter(1, user.getIdProfile().getFullName())
				.setParameter(2, user.getIdProfile().getAddress()).setParameter(3, user.getIdProfile().getNoHp())
				.getSingleResult();
		return Long.parseLong(String.valueOf(result));
	}

}
