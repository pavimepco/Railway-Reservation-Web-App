package com.chainsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email =request.getParameter("email");	
		String password =request.getParameter("password");
		
		Passenger pass = new Passenger();
		
		pass.setEmail(email);
		pass.setPassword(password);
		
		PassengerDAO dao = new PassengerDAO();
		PrintWriter out = response.getWriter();
		try {
			
			
			boolean b = dao.existingPassenger(pass);
			if(b){	
				
				if(pass.getEmail().equalsIgnoreCase("admin@gmail.com") && pass.getPassword().equals("train")){
					  RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					  rd.forward(request, response);
				}
								
				  HttpSession session=request.getSession();  
			      session.setAttribute("email",email);  
			        
			      request.setAttribute("email",email);
				  RequestDispatcher rd = request.getRequestDispatcher("trainBooking.jsp");
				  rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("incorrectLogin.html");		
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
