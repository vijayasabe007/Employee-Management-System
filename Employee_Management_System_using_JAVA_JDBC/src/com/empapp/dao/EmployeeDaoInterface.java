package com.empapp.dao;

import com.empapp.POJO.Employee;

public interface EmployeeDaoInterface {

	// create employee

	public void createEmployee(Employee employee);

	// show all employee

	public void showAllEmploye();

	// show employee based on id

	public void showEmployeeBasedOnId(int id);

	// update employee

	public void updateEmployee(int id, String name);

	// delete employee

	public void deleteEmployee(int id);

}
