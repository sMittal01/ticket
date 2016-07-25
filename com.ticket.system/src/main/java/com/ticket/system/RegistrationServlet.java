package com.ticket.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticket.system.beans.LogonBean;

public class RegistrationServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String pwd = request.getParameter("password");
		LogonBean bean = LogonController.getUser(userName, pwd);
		if(null == bean){
			LogonController.getInstance().createUser(userName, pwd);
			request.getSession().setAttribute("message", "User with name :"+ userName + " is created successfully. Kindly login.");
			response.sendRedirect("login.jsp");
		}else{
			request.getSession().setAttribute("Error", "User with name :"+ userName + " already exists");
			response.sendRedirect("error.jsp");
		}

	}
	
}
