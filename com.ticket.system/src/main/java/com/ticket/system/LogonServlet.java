package com.ticket.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ticket.system.beans.LogonBean;
import com.ticket.system.beans.TicketBean;

public class LogonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Gson gson = new Gson();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		TicketBean bean = TicketController.getInstance().getTicket(value);
		request.getSession().setAttribute("bean", gson.toJson(bean));
		response.sendRedirect("ticketdetails.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String pwd = request.getParameter("password");
		LogonBean bean = LogonController.getUser(userName, pwd);
		if(null == bean){
			request.getSession().setAttribute("Error", "User with name :"+ userName + " does not exist. Please register");
			response.sendRedirect("error.jsp");
			return ;
		}
		
		if(null != bean && !bean.getPassword().equalsIgnoreCase(pwd)){
			request.getSession().setAttribute("Error", "Invalid Password! Please login again");
			response.sendRedirect("error.jsp");
			return ;
		}
		
		request.getSession().setAttribute("UserName", bean.getUserName());
		List<TicketBean> aList = TicketController.getInstance().getTicketList(bean.getUserName());
		
		request.getSession().setAttribute("ObjectList", gson.toJson(aList));
		response.sendRedirect("ticket.jsp");
	}

}
