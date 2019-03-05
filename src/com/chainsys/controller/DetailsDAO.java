package com.chainsys.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailsDAO {
	ResultSet rset=null;
	
	public void addDetails(Details d)throws SQLException{
		try{
		String sql="insert into details(seats,category)values(?,?)";
		Connection connection=ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
	
		preparedStatement.setInt(1,d.getSeats());
		preparedStatement.setString(2,d.getCategory());
	
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected:"+rows);
	     ConnectionUtil.closeConnection(connection, preparedStatement, null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
public ArrayList<Passenger> findAll(String email)throws SQLException{
	 Passenger p=new Passenger();
		String sql="select name,gender,age,mobile_number from passengers where mail_id=?";
		Connection connection=ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,email);
		rset=preparedStatement.executeQuery();
		ArrayList<Passenger> list=new ArrayList<>();
		while(rset.next())
		{
		
		 p.setName(rset.getString("name"));
		 p.setGender(rset.getString("gender"));
		 p.setAge(rset.getInt("age"));
		 p.setMobileNumber(rset.getLong("mobile_Number"));
		 
		 list.add(p);
		}
		ConnectionUtil.closeConnection(connection, preparedStatement, null);
		return list;
	
		
	}
			
		
	}
	
	
