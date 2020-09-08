import java.util.List;

import com.revature.models.Users;
import com.revature.reimDAOs.*;
import com.revature.reimServices.*;
import com.revature.reimUtil.*;


public class Driver {
	private static UsersService ud=new UsersService();
	private static UsersService usrv=new UsersService();
	
	
	public static void main(String[] args) {
		String pswd="sky";
		StringBuilder sb=new StringBuilder();
		sb.append(pswd);
//		List <Users>ls=ud.findAll();
//		//ud.findAll();
//		for(int i=0;i<ls.size();i++) {
//		System.out.println(ls.get(i));
	//}
		int id=1;
		Users result=ud.findById(id);
		System.out.println(result);
	}
}
