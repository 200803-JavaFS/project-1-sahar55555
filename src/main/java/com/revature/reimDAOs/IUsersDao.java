package com.revature.reimDAOs;

import java.util.List;

import com.revature.models.Users;

public interface IUsersDao {
	
		
		public List<Users> findAll();
		
		public Users findById(int id);
		
		public boolean addUser(Users a);

		public void insert(Users usr);
		
		public Users getUbypswd(String pswd);

		public Users getUserByUsername(String nm);
		
		public boolean updateUsers(Users usrs);

	}


