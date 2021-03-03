package com.lawencon.laundry.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.laundry.model.Users;

/**
 * 
 * @author WILLIAM
 *
 */
public class UsersDaoNativeImpl extends BaseDao implements UsersDao {

	@Override
	public Users getUserByPassword(String inputUsername, String inputPassword) throws Exception {
		String sqlBuilder = bBuilder("SELECT u.id, u.username, u.password, ",
				"u.id_outlets, u.id_role, r.role_code, u.id_profile ", "FROM t_m_users u ",
				"inner join t_m_outlets o on o.id = u.id_outlets ",
				"inner join t_m_profile_users p on p.id = u.id_profile ", "inner join t_m_roles r on r.id = u.id_role ",
				"WHERE u.username = ? and u.password = ?").toString();
		List<Users> ul = new ArrayList<>();
		ul = getSession().createNativeQuery(sqlBuilder, // sama dengan INNER JOIN universitas as u on u.id =
														// m.universitas_id
				Users.class).setParameter(1, inputUsername).setParameter(2, inputPassword).list();
		if (ul.size() != 0) {
			return ul.get(0);
		} else
			return null;
	}

	@Override
	public void insertCashier(Users user, Long idProfile, Long idOutlets) throws SQLException {
		String sqlBuilder = bBuilder("INSERT INTO t_m_users ", "(username, password, id_role, id_profile, id_outlets) ",
				"values(?, ?, 2, ?, ?)").toString();
		getSession().createNativeQuery(sqlBuilder).setParameter(1, user.getUserName())
				.setParameter(2, user.getPassword()).setParameter(3, idProfile).setParameter(4, idOutlets)
				.executeUpdate();
	}

	@Override
	public List<Users> getAllCashier() throws Exception {
		List<Users> ul = new ArrayList<>();
		String sqlBuilder = bBuilder("SELECT * FROM t_m_users u ", "WHERE u.id_role = 2").toString();
		ul = getSession().createNativeQuery(sqlBuilder, Users.class).list();
		return ul;
	}

	@Override
	public Users getCashierByUsername(String inputUsername) throws Exception {
		String sqlBuilder = bBuilder("SELECT * FROM t_m_users u ", "WHERE u.username = ? and id_role = 2").toString();
		List<Users> listUser = new ArrayList<>();
		listUser = getSession().createNativeQuery(sqlBuilder, Users.class).setParameter(1, inputUsername).list();
		return listUser.get(0);
	}

}
