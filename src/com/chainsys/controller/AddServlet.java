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
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		int duration = Integer.parseInt(request.getParameter("duration"));
		String category = request.getParameter("category");
		int price = Integer.parseInt(request.getParameter("price"));
		
             
		Train train = new Train();
		train.setId(id);
		train.setName(name);
		train.setSource(source);
		train.setDestination(destination);
		train.setDuration(duration);
		train.setCategory(category);
		train.setPrice(price);
		
		
		TrainDAO dao = new TrainDAO();
		try {
			HttpSession session=request.getSession();  
		    String email= (String)session.getAttribute("email");  	        
		    request.setAttribute("email",email);
					
			dao.addTrain(train);
		
			RequestDispatcher rd = request.getRequestDispatcher("success.html");
			rd.include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("failure.html");
			rd.include(request, response);
		}

		doGet(request, response);
	}

}
