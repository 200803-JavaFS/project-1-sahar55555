package com.revature.reimDAOs;

import java.util.List;

import com.revature.models.Users;
import com.revature.models.reimbursement;
import com.revature.models.status;

public interface IreimbursementDAO {

	

	//reimbursement findByID(int id);

	//boolean updaterem(reimbursement rem);

	List<reimbursement> findAll();

	boolean addRem(reimbursement rem);

	//List<reimbursement> findremByStatus(status stts);

	public List<reimbursement> getallremByAuthor(Users usrs);
	
	public boolean updatereimbursement(reimbursement rem);

	reimbursement findremById(int remid);

	List<reimbursement> findremByStatus(int status);

	

	//int findByusrId(int reslvrId);
	

}
