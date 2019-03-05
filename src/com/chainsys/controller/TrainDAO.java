package com.chainsys.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrainDAO {
	public ArrayList findAll(Train train) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM train";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		ResultSet resultset = stmt.executeQuery();
		ArrayList<Train> tlist = new ArrayList<>();
		while (resultset.next()) {
			Train trainobj = new Train();
			trainobj.setId(resultset.getString("id"));
			trainobj.setName(resultset.getString("name"));
			trainobj.setSource(resultset.getString("source"));
			trainobj.setDestination(resultset.getString("destination"));
			trainobj.setDuration(resultset.getInt("duration"));
			trainobj.setCategory(resultset.getString("category"));
			trainobj.setPrice(resultset.getInt("price"));
			tlist.add(trainobj);
		}
		return tlist;
	}

	public int getPrice(int id) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT price FROM train WHERE id=" + id;
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet resultset = stmt.executeQuery();
		while (resultset.next()) {
			return resultset.getInt(1);
		}
		return 0;
	}

       public Train findById(int id)throws SQLException{
		ResultSet rset=null;
		String sql="select id,name,source,destination,duration,category,price from train where id=?";
		Connection connection=ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		rset=preparedStatement.executeQuery();
		Train t=null;
		if(rset.next())
		{
		 t=new Train();
		 t.setPrice(rset.getInt("price"));
			
		 
		 ConnectionUtil.closeConnection(connection, preparedStatement, null);
			}
		return t;						
}

       public void addTrain(Train t)throws SQLException{
   		try{
   		String sql="insert into train(id,name,source,destination,duration,category,price)values(?,?,?,?,?,?,?)";
   		Connection connection=ConnectionUtil.getConnection();
   		PreparedStatement preparedStatement=connection.prepareStatement(sql);
      				
   		preparedStatement.setString(1,t.getId());
   		preparedStatement.setString(2,t.getName());
   		preparedStatement.setString(3,t.getSource());
   		preparedStatement.setString(4,t.getDestination());
   		preparedStatement.setInt(5,t.getDuration());
   		preparedStatement.setString(6,t.getCategory());
   		preparedStatement.setInt(7,t.getPrice());
   
   		
   		int rows=preparedStatement.executeUpdate();
   		System.out.println("Rows affected:"+rows);
   	     ConnectionUtil.closeConnection(connection, preparedStatement, null);
   		}
   		catch(Exception e){
   			e.printStackTrace();
   		}
   	
   	}
              
       public void deleteTrain(String id)throws SQLException{	
   		try{
   		String sql="delete from train where id=?";
   		Connection connection=ConnectionUtil.getConnection();
   		PreparedStatement preparedStatement=connection.prepareStatement(sql);
   		preparedStatement.setString(1,id);
   		int rows=preparedStatement.executeUpdate();
   		System.out.println("Rows affected:"+rows);
   		 ConnectionUtil.closeConnection(connection, preparedStatement, null);
   		}
   		catch(Exception e){
   			e.printStackTrace();
   		}
   	}
       
}
