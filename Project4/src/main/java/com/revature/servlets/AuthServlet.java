package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDao;
import com.revature.models.User;

public class AuthServlet extends HttpServlet {

	private UserDao userDao = UserDao.currentImplementation;
	ObjectMapper om = new ObjectMapper();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("uri = " + req.getRequestURI());
		if ("/project4/auth/login".equals(req.getRequestURI())) {
			User credentials = (User) om.readValue(req.getReader(), User.class);
			System.out.println(credentials.toString());
			User loggedInUser = userDao.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
			if (loggedInUser == null) {
				System.out.println(401);
				resp.setStatus(401); // Unauthorized status code
				return;
			} else {
				System.out.println(201);
				resp.setStatus(201);
				req.getSession().setAttribute("User", loggedInUser);
				resp.getWriter().write(om.writeValueAsString(loggedInUser));
				return;
			}
		} else if ("/project4/auth/logout".equals(req.getRequestURI())) {
			System.out.println("logged out");
			resp.setStatus(201); // success code
			req.getSession().invalidate();
			return;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/project1/auth/session-user".equals(req.getRequestURI())) {
			String json = om.writeValueAsString(req.getSession().getAttribute("user"));
			resp.getWriter().write(json);
		}
	}
}
