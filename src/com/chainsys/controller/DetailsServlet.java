package com.chainsys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DetailsServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sea=request.getParameter("bseats");
		
		System.out.println(sea);
		int seats=Integer.parseInt(sea);
		System.out.println(seats);
		

		Details d= new Details();
		d.setSeats(seats);
		
		HttpSession session=request.getSession();
		int price=(int) session.getAttribute("price");
        String mail=(String) session.getAttribute("email");
		System.out.println(mail); 

		DetailsDAO dao = new DetailsDAO();
		ArrayList<Passenger>pass=new ArrayList<>();
				
			try {
			//	dao.addDetails(d);
				
				
				double total=price*seats;
				request.setAttribute("total", total);
				d.setTotal(total);
				request.setAttribute("seats", seats);	
				
				pass=dao.findAll(mail);
				System.out.println(pass);
				
				d.setName(pass.get(0).getName());
				d.setGender(pass.get(0).getGender());
				d.setAge(pass.get(0).getAge());
				d.setMobile_number(pass.get(0).getMobileNumber());
				
				dao.addDetails(d);
				
				request.setAttribute("FINAL", pass);
				
				RequestDispatcher rd = request.getRequestDispatcher("final.jsp");
				rd.forward(request, response);
			}   catch (SQLException e) {
				
				e.printStackTrace();
			}       
	}

}
