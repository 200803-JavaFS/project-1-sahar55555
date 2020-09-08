package com.revature.reimServices;

import com.revature.models.LoginDTO;
import com.revature.reimServices.UsersService;
import com.revature.models.Users;
import com.revature.reimDAOs.UsersDao;


public class LoginService {
	
	public UsersDao usrv = new UsersDao();
	
	public boolean login(LoginDTO l) {
	
		try {
			String usrnm=l.username;
			String usrpswd=l.password;
			
			Users usrs=usrv.getUserByUsername(usrnm);
			if(usrs !=null)
			{
				StringBuilder st=new StringBuilder();
				st.append(usrpswd.hashCode());
				String hshpswd=st.toString();
				if(usrs.getUsrpaswd().equals(usrpswd)) {
					return true;
				}else {
					System.out.println(usrpswd);
					System.out.println(usrs.getUsrpaswd());
					System.out.println("password doesn't match");
				}
			}
			
		}catch (NullPointerException e) {
		System.out.println("We don't have that name in our system");	
		e.printStackTrace();
	}
		return false;
}
}
