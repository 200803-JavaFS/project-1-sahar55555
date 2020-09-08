package com.revature.reimController;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;
import com.revature.models.reim_type;
import com.revature.models.reimbDto;
import com.revature.models.reimbursement;
import com.revature.models.status;
import com.revature.reimDAOs.reimbursDao;
import com.revature.reimServices.UsersService;
import com.revature.reimServices.reimbursemServices;

import java.sql.Timestamp;

public class reimbursementController {
	
	private static reimbursemServices rs=new reimbursemServices();
	private static ObjectMapper om=new ObjectMapper();
	private static reimbursDao remdao=new reimbursDao();
	private static UsersService usrvice=new UsersService();
	
	
	
	public void getReimbrsementById(HttpServletResponse res,int id )throws IOException{
	//get a reimbursement by id and send it back
		reimbursement rem=rs.getreimbursementById(id);
		
		if(rem==null) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			String json=om.writeValueAsString(rem);
			res.getWriter().println(json);
		}
	}
	// get all rembursements and send it back in the response
	public void getAllreimbursements(HttpServletResponse res) throws IOException {
		System.out.println("Controller");
		List<reimbursement> allrems=rs.findAll();
		res.setStatus(200);
		String json=om.writeValueAsString(allrems);
		res.getWriter().println(json);
	}
	
	//get all reimbursements by author and send it back
	public void getAllreimbursementByAuthor(HttpServletResponse res,int usrId)throws IOException{
	
		Users usrs=usrvice.findById(usrId);
		List<reimbursement> allrems_authr=rs.getallremByAuthor(usrs);
		if(allrems_authr!=null &&allrems_authr.isEmpty()) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			String json=om.writeValueAsString(allrems_authr);
			res.getWriter().println(json);
		}
	}
	// add a new reimbursement to database
	
	public void addreimbursement(HttpServletRequest req,HttpServletResponse res) throws IOException{
		BufferedReader br=req.getReader();
		StringBuilder sb=new StringBuilder();
		String line=br.readLine();
		while(line !=null) {
			sb.append(line);
			line=br.readLine();
		}
		
		String body=new String(sb);
		
		System.out.println(body);
		
		reimbDto rem=om.readValue(body, reimbDto.class);
		double remamt=rem.getAmt();
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		String remdescption=rem.getDescription();
		
		status stts=new status(11,"pending");
		String username=(String)req.getSession().getAttribute("username");
	    Users author = usrvice.getUserByUsername(username);
	    System.out.println("Status is :"+stts);
	    
	   // Users author=usrvice.findById(u.getUserid());
		
		String tp=rem.getrType();
		reim_type remtp=null;
		
		if(tp.toLowerCase().equals("food")) {
			remtp=new reim_type(3,"food");
		}
		
		if(tp.toLowerCase().equals("lodging")) {
			remtp=new reim_type(1,"lodging");
		}
		if(tp.toLowerCase().equals("travel")) {
			remtp=new reim_type(2,"travel");
		}
		if(tp.toLowerCase().equals("other")) {
			remtp=new reim_type(4,"other");
		}
		


		reimbursement addrembs=new reimbursement(remamt, ts, null, remdescption, author, null,stts, remtp);
            if(rs.addRem(addrembs)) {
            	res.setStatus(201);
            	res.getWriter().println("Reimbursement has been created");
            }else {
            		res.setStatus(403);
            	}
            }
	
	public void getAllReimbursementsByStatus(HttpServletResponse res, int statusId) throws IOException {
		List<reimbursement> allReimb = rs.getAllReimbursementsByStatus(statusId);
		
		
		if(allReimb.isEmpty()) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			String json = om.writeValueAsString(allReimb);
			res.getWriter().println(json);
			
		}
	}
	
	
	public void updateStatus(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader= req.getReader();
		StringBuilder s=new StringBuilder();
		String line = reader.readLine();
		while(line!=null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		reimbDto rdto= om.readValue(body, reimbDto.class);
		System.out.println("body that is taken in from java: "+ rdto);
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		
		
		int reimbId= rdto.getId();
		reimbursement r = rs.findremById(reimbId);
		
		String status= rdto.getrStatus();
		System.out.println("new status:" +status);
		
		status rStatus = null;
		if (status.equals("Approved")) {
			rStatus= new status(10,"approved");
		}else if (status.equals("Denied")) {
			rStatus= new status(12,"denied");
		}

	    String username=(String)req.getSession().getAttribute("username");
	    Users resolver = usrvice.getUserByUsername(username);

//		int resolverId= rdto.getrAuthorId();
//		System.out.println("resolver id: "+ resolverId);
		
		
		r.setReim_sttsId(rStatus);
		r.setReim_resolvd(ts);
//		Users resolver= usrvice.findById(resolverId);
		System.out.println("resolver: " + resolver);
		r.setReim_resolr(resolver);
		System.out.println(r);
		
		if (rs.updateReimbursement(r)) {
			res.setStatus(201);
			res.getWriter().println("Reimbursement was updated");
		}else {
			res.setStatus(403);
		}
		
	}
}
	

