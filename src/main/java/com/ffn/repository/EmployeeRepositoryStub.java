package com.ffn.repository;

import java.util.ArrayList;
import java.util.List;

import com.ffn.model.EmployeeInformation;
import com.ffn.model.User;

public class EmployeeRepositoryStub implements EmployeeRepository{

	
	public void create(EmployeeInformation employeeinformation) {
		//insert statements
	
	}

	public List<EmployeeInformation> findAllEmployees() {
		
		List<EmployeeInformation> employeeinformation = new ArrayList<EmployeeInformation>();
		EmployeeInformation employee1 = new EmployeeInformation();
		employee1.setId(1);
		employee1.setFirstName("John");
		employee1.setLastName("Doe");
		employee1.setDepartment("Fianance");
		employee1.setJobTitle("CFO");
		
		employeeinformation.add(employee1);
		
		EmployeeInformation employee2 = new EmployeeInformation();
		employee2.setId(2);
		employee2.setFirstName("Jane");
		employee2.setLastName("Doe");
		employee2.setDepartment("Human Resources");
		employee2.setJobTitle("HR MANAGER");
		
		employeeinformation.add(employee2);
	
		EmployeeInformation employee3 = new EmployeeInformation();
		employee3.setId(3);
		employee3.setFirstName("THOMAS");
		employee3.setLastName("SMITH");
		employee3.setDepartment("Information Technology");
		employee3.setJobTitle("Software Developer");
		
		employeeinformation.add(employee3);
		
		return employeeinformation;
	}

	
	public EmployeeInformation findEmployee(int employeeId) {
		
		EmployeeInformation employee1 = new EmployeeInformation();
		employee1.setId(1);
		employee1.setFirstName("John");
		employee1.setLastName("Doe");
		employee1.setDepartment("Fianance");
		employee1.setJobTitle("CFO");
		return employee1;
	}



	public EmployeeInformation getDeptEmployees(String department) {
		
		EmployeeInformation employee1 = new EmployeeInformation();
		employee1.setId(1);
		employee1.setFirstName("John");
		employee1.setLastName("Doe");
		employee1.setDepartment("Fianance");
		employee1.setJobTitle("CFO");
		
		User user = new User();
		
		user.setId(1);
		user.setFirstName("Jack");
		user.setLastName("Nicolson");
		employee1.setUser(user);
		
		return employee1;
	}


	public EmployeeInformation update(EmployeeInformation employeeinformation) {
		//search database if we have a employee with that ID
		//if no return insert the employee into database else update the employee table
		return employeeinformation;
	}

	
	public void delete(int employeeId) {
		//delete from table where employeid = employeeId
		
	}
		
}

