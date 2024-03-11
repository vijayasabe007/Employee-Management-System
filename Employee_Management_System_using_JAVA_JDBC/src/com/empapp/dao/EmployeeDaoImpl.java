package com.empapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.empapp.POJO.Employee;
import com.empapp.connection.DbConnection;

public class EmployeeDaoImpl implements EmployeeDaoInterface {

	Connection conn;

	@Override
	public void createEmployee(Employee employee) {

		conn = DbConnection.createDBConnection();
		// getting the connection

		String query = "insert into Employee values(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.setInt(4, employee.getAge());

			int cnt = preparedStatement.executeUpdate();
			if (cnt != 0) {
				System.out.println("Employee Inserted Sucessfully !!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void showAllEmploye() {
		// preparedStatement is dynamic qury
		// Statement is static query
		conn = DbConnection.createDBConnection();
		String query = "select * from employee";
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			System.out.format("%s\t%s\t%s\t\t%s\n", "ID", "Name", "Salary", "Age");
			System.out.println("-----------------------------------------------");
			while (resultSet.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", resultSet.getInt(1), resultSet.getString(2),
						resultSet.getDouble(3), resultSet.getInt(4));
				System.out.println("-----------------------------------------------");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void showEmployeeBasedOnId(int id) {
		conn = DbConnection.createDBConnection();
		String query = "select * from employee where id=" + id;
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			System.out.format("%s\t%s\t%s\t\t%s\n", "ID", "Name", "Salary", "Age");
			System.out.println("-----------------------------------------------");
			while (resultSet.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", resultSet.getInt(1), resultSet.getString(2),
						resultSet.getDouble(3), resultSet.getInt(4));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void updateEmployee(int id, String name) {
		conn = DbConnection.createDBConnection();
		String query = "update employee set name=? where id=?";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);

			int cnt = preparedStatement.executeUpdate();

			if (cnt != 0) {
				System.out.println("Employee record updated successfully !!!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void deleteEmployee(int id) {
		conn = DbConnection.createDBConnection();

		String query = "delete from employee where id=?";

		try {

			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);

			int cnt = preparedStatement.executeUpdate();
			if (cnt != 0) {
				System.out.println("Employee record deleted successfully !!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
