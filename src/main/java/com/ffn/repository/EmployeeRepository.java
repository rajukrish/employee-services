package com.ffn.repository;

import java.util.List;

import com.ffn.model.EmployeeInformation;


public interface EmployeeRepository {

	List<EmployeeInformation> findAllEmployees();

	EmployeeInformation findEmployee(int employeeId);

	EmployeeInformation getDeptEmployees(String department);

	void create(EmployeeInformation employeeinformation);
	
	EmployeeInformation update(EmployeeInformation employeeinformation);

	void delete(int employeeId);
}
