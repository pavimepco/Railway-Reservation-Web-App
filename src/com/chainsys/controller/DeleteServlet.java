package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		TrainDAO dao=new TrainDAO();
		try {
			
			HttpSession session=request.getSession();  
		    String email= (String)session.getAttribute("email");  		        
		    request.setAttribute("email",email);
						
			dao.deleteTrain(id);			
			RequestDispatcher rd=request.getRequestDispatcher("success.html");
		    rd.include(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("failure.html");
		    rd.include(request, response);
		}
		doGet(request, response);
	}

}
