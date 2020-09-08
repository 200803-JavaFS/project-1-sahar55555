package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.LoginDTO;
import com.revature.models.Users;
import com.revature.reimController.LoginController;
import com.revature.reimController.UserController;
import com.revature.reimController.UsersController;
import com.revature.reimController.reimbursementController;
import com.revature.reimDAOs.reimbursDao;
import com.revature.reimServices.UsersService;



public class MasterServlet extends HttpServlet {

	private static UsersController ac = new UsersController();
	private static LoginController lc = new LoginController();
	private static reimbursementController rmc=new reimbursementController();
	private static UserController uc = new UserController();
	private static UsersService us=new UsersService();
	private static final Logger log = LogManager.getLogger(MasterServlet.class);

	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		// By default tomcat will send back a successful status code if it finds a
		// servlet method.
		// Because all requests will hit this method, we are defaulting to not found and
		// will override for success requests.
		res.setStatus(404);

		final String URI = req.getRequestURI().replace("/project0/", "");

		// example URI = avenger/1 to get avenger with ID 1

		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));
		//get all reimbur
		//get all reimbursement by author
		//get all reimbursements by status 
		if(portions.length==0) {
			req.getRequestDispatcher("index.html").forward(req, res);
		}
		HttpSession ses=req.getSession(false);
		try {
			
			switch (portions[0]) {
			
			case "login":
				lc.login(req, res);
				break;
			case "success":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
					//Users u =  req.getSession().getAttribute("user");
				    String username=(String)req.getSession().getAttribute("username");
				    Users u = us.getUserByUsername(username);
					System.out.println(req.getSession().getAttribute("username"));
					log.info("User name is : "+username);
					
					if(req.getMethod().equals("GET")) {
						uc.sendUserRole(req, res, u);
					}
				}
				break;
				
			case "reimbursemnets":
				System.out.println("[reimbursemnets] Ready to go to getAllreimbursements");
				rmc.getAllreimbursements(res); 
				break;

			case "getPending":
				rmc.getAllReimbursementsByStatus(res, 11);
				break;

			case "reimbursementsbyauthor":
				int rauthorId=Integer.parseInt(portions[1]);
				rmc.getAllreimbursementByAuthor(res, rauthorId);
			break;

			case "myreimbursements":
			    String username=(String)req.getSession().getAttribute("username");
			    Users u = us.getUserByUsername(username);
				rmc.getAllreimbursementByAuthor(res, u.getUserid());
			break;
			
			case "updatestatus":
				rmc.updateStatus(req, res);
			break;

			case "logout":
				lc.login(req, res);
				break;
			case "addticket":
				rmc.addreimbursement(req, res);
				break;
//			case "employee":
//					RequestDispatcher rd=null;
//					rd=req.getRequestDispatcher("employee.html");
//			break;
			}//End of switch
		}//End of try method
		catch (NumberFormatException e) {
				e.printStackTrace();
				res.getWriter().print("The id you provided is not an integer");
				res.setStatus(400);
		}
	

				
//			case"addreimbursement":
//				
//				if (ses != null && (boolean) ses.getAttribute("loggedin")) {
//					//LoginDTO lgndt=(LoginDTO)ses.getAttribute("user");
//					rmc.addreimbursement(req, res);
//					//req is going to come from javascript
//					
//				} else {
//					res.setStatus(403);
//					res.getWriter().println("You must be logged in to do that!");
//				}
//				
//			
//				break;
//			case "login":
//				lc.login(req, res);
//				break;
//			case "logout":
//				lc.logout(req, res);
//				break;
			

	}	
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
		
	}
	

	}
//		res.setContentType("application/json");
//		// By default tomcat will send back a successful status code if it finds a
//		// servlet method.
//		// Because all requests will hit this method, we are defaulting to not found and
//		// will override for success requests.
//		res.setStatus(404);
//
//		final String URI = req.getRequestURI().replace("/project0/", "");
//
//		// example URI = avenger/1 to get avenger with ID 1
//
//		String[] portions = URI.split("/");
//
//		System.out.println(Arrays.toString(portions));
//		//get all reimbur
//		//get all reimbursement by author
//		//get all reimbursements by status
//		if(portions.length==0) {
//			req.getRequestDispatcher("index.html").forward(req, res);
//		}
//		HttpSession ses=req.getSession();
//		try {
//			switch (portions[0]) {
//			case"login":
//				lc.login(req, res);
//				break;
//				
//			case"logout":
//				
//			break;
//			
//			case"addreimbursement":
//			
//			if (ses != null && (boolean) ses.getAttribute("loggedin")) {
//				//LoginDTO lgndt=(LoginDTO)ses.getAttribute("user");
//				rmc.addreimbursement(req, res);
//				//req is going to come from javascript
//				
//			} else {
//				res.setStatus(403);
//				res.getWriter().println("You must be logged in to do that!");
//			}
//			
//		
//			break;
//			}
//		}
//		catch (NumberFormatException e) {
//		e.printStackTrace();
//		res.getWriter().print("The id you provided is not an integer");
//		res.setStatus(400);
//		}
	//case"getAllreimbursements":
//		
//		if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
//			rmc.getAllreimbursements(res);
//				
//		} else {
//			res.setStatus(403);
//			res.getWriter().println("You must be logged in to do that!");
//		}
//		break;
//		
//	case"getAllreimbursementByAuthor":
//		if (ses != null && (boolean) ses.getAttribute("loggedin")) {
//			LoginDTO lgndt=(LoginDTO)ses.getAttribute("user");
//			rmc.getAllreimbursementByAuthor(res, lgndt.username);
//				
//		} else {
//			res.setStatus(403);
//			res.getWriter().println("You must be logged in to do that!");
//		}
//		break;
//	} 

	
