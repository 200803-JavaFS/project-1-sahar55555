package com.revature.reimServices;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Users;
import com.revature.models.reimbursement;
import com.revature.models.status;
import com.revature.reimDAOs.IreimbursementDAO;
import com.revature.reimDAOs.UsersDao;
import com.revature.reimDAOs.reimbursDao;

public class reimbursemServices {
	//private static final log=LogManage.getLogger(reimbursemServices.class);
	private static final Logger log = LogManager.getLogger(reimbursemServices.class);
    private static IreimbursementDAO remdao = new reimbursDao();
    private static UsersDao usd=new UsersDao();

	
	public List<reimbursement>findAll() {
		log.info(" Reimbrsement list");
		System.out.println("Services");
		return remdao.findAll();
	}
	
	public List<reimbursement> findremByStatus(int stts){
		log.info("Reimbursement list by Status" );
		return remdao.findremByStatus(stts);
	}
	
	public boolean addRem(reimbursement rem) {
		log.info("Adding new reimbursement"+rem);
		return remdao.addRem(rem);
	}
	public List<reimbursement> getallremByAuthor(Users author)
	{
		log.info("find a remibursement bu the user "+author);
		//Users u=usd.findusrByusrnm(usrs);
		return remdao.getallremByAuthor(author);
	}
	
	//public update reimbursement by the manager
//	public void updatereimbursement(status rs,int reimbId, int reslvrId) {
//		reimbursement rem = remdao.findremById(reimbId);
//		rem.setReim_sttsId(rs);
//		Users usr = usd.findById(reslvrId);
//		rem.setReim_resolr(usr);
//		remdao.updatereimbursement(rem);
//	}
	
	public boolean updateReimbursement(reimbursement r) {
		log.info("Updating reimbursement: "+ r);
		return remdao.updatereimbursement(r);
		
	}

	public reimbursement findremById( int id) {
		log.info("Getting single reimbursement by id:"+id);
		return remdao.findremById(id);
		
	}
//	public List<reimbursement> getremsByAuthor(Users athr){
//		log.info(" listing all reimbursements by author :"+athr);
//		return remdao.getallremByAuthor(athr);
//	}

	public reimbursement getreimbursementById(int id) {
		log.info("Get reimbursements by Id :"+id);
		return remdao.findremById(id);
	}

	
	public List<reimbursement>getAllReimbursementsByStatus(int status){
		log.info("Getting all reimbursements by status :"+status);
		return remdao.findremByStatus(status);
	}
//	public int getUserRole(String username) {
//		log.info("Getting User role by username :"+username);
//		return usd.userRoleid(username);
//	
//	}
}

   