package com.chainsys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignUpServlet() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		long mobileNumber=Long.parseLong(request.getParameter("mobileNumber"));
		String gender =request.getParameter("gender");
		String password =request.getParameter("password");
		String email =request.getParameter("email");
		Passenger pass = new Passenger();
		pass.setName(name);
		pass.setAge(age);
		pass.setMobileNumber(mobileNumber);
		pass.setGender(gender);	
		pass.setPassword(password);		
		pass.setEmail(email);
		
		PassengerDAO dao = new PassengerDAO();
				
		try {
		boolean	b=dao.checkPassenger(pass);
			if(b){
				  System.out.println(" Inserting......");
			      dao.addPassenger(pass);
			      RequestDispatcher rd = request.getRequestDispatcher("login.html");
			      rd.forward(request, response);
			}
			else
			{
			 RequestDispatcher rd = request.getRequestDispatcher("incorrectSignUp.html");
			 rd.forward(request, response);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
