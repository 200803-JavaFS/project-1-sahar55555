package com.revature.reimServices;


import java.util.List;

import com.revature.reimDAOs.IUsersDao;
import com.revature.reimDAOs.UsersDao;

import com.revature.models.Users;

public class UsersService {
	
	private static IUsersDao aDao = new UsersDao();
	
	public List<Users> findAll() {
		return aDao.findAll();
	}
	
	public Users findById(int id) {
		return aDao.findById(id);
	}
	
	public boolean addUser(Users a) {
		return aDao.addUser(a);
	}

}