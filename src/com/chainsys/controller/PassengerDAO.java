package com.chainsys.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDAO {

	
		ResultSet resultSet = null;

		public void addPassenger(Passenger pass) throws Exception {
			try {
				Connection connection = ConnectionUtil.getConnection();
				System.out.println(connection);
				String sql = "insert into passengers(mail_id,password,name,gender,age,mobile_number)values(?,?,?,?,?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(3, pass.getName());
				preparedStatement.setString(4, pass.getGender());
				preparedStatement.setInt(5, pass.getAge());
				preparedStatement.setString(1, pass.getEmail());
				preparedStatement.setString(2, pass.getPassword());
				preparedStatement.setLong(6, pass.getMobileNumber());

				int rows = preparedStatement.executeUpdate();
				System.out.println("Rows inserted: " + rows);
				ConnectionUtil.close(connection, preparedStatement, resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public boolean existingPassenger(Passenger pass) throws SQLException {
			boolean login = false;
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select mail_id,password from passengers where mail_id=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			try {
				preparedStatement.setString(1, pass.getEmail());
				preparedStatement.setString(2, pass.getPassword());
				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {

					String checkPassenger = resultSet.getString(1);
					String checkPass = resultSet.getString(2);
					if ((checkPassenger.equalsIgnoreCase(pass.getEmail()))
							&& (checkPass.equals(pass.getPassword()))) {
						login = true;
					} else {
						login = false;
					}
				} else {
					System.out.println("invalid");
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
			return login;
		}

		public boolean checkPassenger(Passenger pass) throws SQLException {
			boolean signup = false;
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select mail_id from passengers where mail_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1,pass.getEmail());
			resultSet = preparedStatement.executeQuery();

			try {
				if (resultSet.next()) {					
					signup = false;
					return signup;

				} else {
					signup = true;
					return signup;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return signup;
		}
	}

