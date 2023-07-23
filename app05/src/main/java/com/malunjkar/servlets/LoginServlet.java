package com.malunjkar.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.malunjkar.factory.UserServiceFactory;
import com.malunjkar.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		UserService userService =UserServiceFactory.getUserService();
		String status = userService.checkLogin(uname, upwd);
		RequestDispatcher requestDispatcher =null;
		if("success".equals(status)) {
			requestDispatcher=request.getRequestDispatcher("success.html");
			requestDispatcher.forward(request, response);
		}else {
			requestDispatcher=request.getRequestDispatcher("failure.html");
			requestDispatcher.forward(request, response);
		}
	}

}
