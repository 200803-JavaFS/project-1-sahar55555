package com.revature.reimController;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.reimDAOs.UsersDao;
import com.revature.reimDAOs.reimbursDao;
import com.revature.reimServices.LoginService;

public class LoginController {

	private static LoginService ls = new LoginService();
	private static ObjectMapper om = new ObjectMapper();
	private static UsersDao usdo=new UsersDao();
	private static final Logger log = LogManager.getLogger(LoginController.class);
	

	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {

		if (req.getMethod().equals("GET")) {
			// This shows loging in with query params for example purposes only.Do not ever
			// actually do this!
			//getParameterMap is grabbing from js 
//			if (req.getParameterMap().containsKey("username") && req.getParameterMap().containsKey("password")) {
//				LoginDTO l = new LoginDTO();
//				l.username = req.getParameter("username");
//				l.password = req.getParameter("password");
//
//				if (ls.login(l)) {
//					HttpSession ses = req.getSession();
//					ses.setAttribute("user",(String) l.username);
//					ses.setAttribute("username",(String) l.username);
//					ses.setAttribute("loggedin", true);
//					res.setStatus(200);
//					//res.getWriter().println("Login Successful");
//					log.info(" username is : "+l.username);
//					
//				} else {
//					HttpSession ses = req.getSession(false);
//					if (ses != null) {
//						ses.invalidate();
//					}
//					res.setStatus(401);
//					res.getWriter().println("Login failed");
//				}
//			}
		} else if (req.getMethod().equals("POST")) {
			// this is how a login should generally be handled. Sending credentials in the
			// body of a POST request.
			BufferedReader reader = req.getReader();

			StringBuilder sb = new StringBuilder();

			String line = reader.readLine();

			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}

			String body = new String(sb);

			LoginDTO l = om.readValue(body, LoginDTO.class);

			if (ls.login(l)) {
				HttpSession ses = req.getSession();
				ses.setAttribute("user", l);
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				ses.setAttribute("username", l.username);
				res.getWriter().println("Login Successful");
			} else {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
				res.getWriter().println("Login failed");
			}

		}
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);

		if (ses != null) {
			LoginDTO l = (LoginDTO) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			res.getWriter().println(l.username + " has logged out successfully");
		} else {
			res.setStatus(400);
			res.getWriter().println("You must be logged in to logout!");
		}
	}

}
