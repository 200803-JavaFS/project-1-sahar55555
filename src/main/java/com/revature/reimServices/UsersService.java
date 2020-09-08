package com.revature.reimServices;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.reimDAOs.IUsersDao;
import com.revature.reimDAOs.UsersDao;

import com.revature.models.Users;

public class UsersService {
	
	private static final Logger log=LogManager.getLogger(UsersService.class);
	private static IUsersDao aDao = new UsersDao();
	
	public UsersService() {
		super();
	}
	
	public List<Users> findAll() {
		log.info("All users list");
		return aDao.findAll();
	}
	
	public Users findById(int i) {
		log.info("Find user by id"+i);
		return aDao.findById(i);
	}
	
	public boolean addUser(Users a) {
		log.info("Add a user"+a);
		return aDao.addUser(a);
	}
	public Users getUserByUsername( String nm) {
		log.info("Find a user by name"+nm);
		return aDao.getUserByUsername(nm);
	}
	
	public Users getUbypswd( String pswd) {
		log.info("Find a user by password"+pswd);
		return aDao.getUbypswd(pswd);
	}

}