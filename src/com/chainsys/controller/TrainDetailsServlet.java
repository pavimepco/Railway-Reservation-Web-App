package com.chainsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TrainDetailsServlet
 */
@WebServlet("/TrainDetailsServlet")
public class TrainDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TrainDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		Train train=new Train();
		train.setSource(from);
		train.setDestination(to);
		TrainDAO dao=new TrainDAO();
		try{
			HttpSession session=request.getSession();  
		    String email= (String)session.getAttribute("email");  		        
		    request.setAttribute("email",email);
			
			ArrayList<Train> trainlist=dao.findAll(train);
			System.out.println(trainlist);
			request.setAttribute("train",trainlist);
			RequestDispatcher rd=request.getRequestDispatcher("trainList.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
