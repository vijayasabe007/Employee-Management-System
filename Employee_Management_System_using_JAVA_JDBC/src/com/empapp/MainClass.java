package com.empapp;

import java.util.Scanner;

import com.empapp.POJO.Employee;
import com.empapp.dao.EmployeeDaoImpl;
import com.empapp.dao.EmployeeDaoInterface;

public class MainClass {

	public static void main(String[] args) {
		EmployeeDaoInterface dao = new EmployeeDaoImpl();
		// to access the dao layer

		System.out.println("*****Welcome to employee Management System*****");
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Add Employee");
			System.out.println("2. Show All Employee");
			System.out.println("3. Show Employee based on id");
			System.out.println("4. Update the employee");
			System.out.println("5. Delete the employee");
			System.out.println("6. Exit");

			System.out.println("Enter choice : ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1: {
				Employee employee = new Employee();
				System.out.println("Enter Id : ");
				int id = sc.nextInt();
				System.out.println("Enter Name : ");
				String name = sc.next();
				System.out.println("Enter Salary : ");
				double salary = sc.nextDouble();
				System.out.println("Enter Age : ");
				int age = sc.nextInt();

				employee.setId(id);
				employee.setName(name);
				employee.setSalary(salary);
				employee.setAge(age);

				dao.createEmployee(employee);
				break;
			}
			case 2:
				dao.showAllEmploye();
				break;
			case 3:
				System.out.println("Enter id to show the details : ");
				int empid = sc.nextInt();
				dao.showEmployeeBasedOnId(empid);
				break;
			case 4:
				System.out.println("Enter id to update the details : ");
				int empid1 = sc.nextInt();
				System.out.println("Enter new name : ");
				String name1 = sc.next();
				dao.updateEmployee(empid1, name1);
				break;
			case 5:

				System.out.println("Enter employee id to delete the record : ");
				int empid2 = sc.nextInt();
				dao.deleteEmployee(empid2);
				break;
			case 6:
				System.out.println("Thank you for using our Application!!!");
				System.exit(0);
				// method provided by System class to exit the program
			default:
				System.out.println("Enter valid choice...");
				break;
			}

		} while (true);

	}

}
