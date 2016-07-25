package com.ticket.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ticket.system.beans.TicketBean;

public class TicketServlet extends HttpServlet {

	/**
	 * 
	 */
	
	private static final Gson gson = new Gson();
	
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= (String)request.getSession().getAttribute("UserName");
		System.out.println(userName);
		String status = request.getParameter("status");
		String processor = request.getParameter("processor");
		String reporter = request.getParameter("reporter");
		if(reporter == null){
			reporter = userName;
		}
		String desc = request.getParameter("desc");
		String id = request.getParameter("id");
		if(null != id){
			TicketController.getInstance().updateTicket(Integer.valueOf(id), status, processor, reporter, desc);
		}else{
			TicketController.getInstance().createTicket(status,processor, reporter, desc);
		}
		
		List<TicketBean> aList = TicketController.getInstance().getTicketList(userName);
		request.getSession().setAttribute("ObjectList", gson.toJson(aList));
		response.sendRedirect("ticket.jsp");
	}

}
