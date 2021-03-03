package com.lawencon.laundry.service;

import java.util.List;

import com.lawencon.laundry.dao.UsersDao;
import com.lawencon.laundry.model.Users;

/**
 * 
 * @author WILLIAM
 *
 */
public class UsersServiceImpl extends BaseService implements UsersService {

	private UsersDao usersDao;
	private UsersProfileService usersProfileService;
	private OutletsService outletsService;

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void setUsersProfileService(UsersProfileService usersProfileService) {
		this.usersProfileService = usersProfileService;
	}

	public void setOutletsService(OutletsService outletsService) {
		this.outletsService = outletsService;
	}

	@Override
	public Users getUserByPassword(String inputUsername, String inputPassword) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return usersDao.getUserByPassword(inputUsername, inputPassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void insertCashier(Users user) throws Exception {
		getTransactionTemplate().executeWithoutResult(val -> {
			Long idProfile = null;
			Long idOutlets = null;
			try {
				idProfile = usersProfileService.insertProfile(user);
				idOutlets = outletsService.getOutletsByCode(user.getIdOutlet().getOutletsCode());
				usersDao.insertCashier(user, idProfile, idOutlets);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public List<Users> getAllCashier() throws Exception {
		List<Users> listResult = getTransactionTemplate().execute(val -> {
			try {
				return usersDao.getAllCashier();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return listResult;
	}

	@Override
	public Users getCashierByUsername(String inputUsername) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return usersDao.getCashierByUsername(inputUsername);
			} catch (Exception e) {

			}
			return null;
		});
	}
}
