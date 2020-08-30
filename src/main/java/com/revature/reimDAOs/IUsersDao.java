package com.revature.reimDAOs;

import java.util.List;

import com.revature.models.Users;

public interface IUsersDao {
	
		
		public List<Users> findAll();
		
		public Users findById(int id);
		
		public boolean addUser(Users a);
		
		public boolean updateAvenger(Users a); 
		
		public boolean deleteUser(int supId);

		public boolean addAvengerWithHome(Users a);

	}


