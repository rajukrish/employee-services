package com.ffn.client;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ffn.model.EmployeeInformation;

public class EmployeeInformationClientTest {
	
	@Test
	public void testDelete(){
		EmployeeInformationClient client = new EmployeeInformationClient();
		client.delete(1);
	}
	
	@Test
	public void testPut(){
		EmployeeInformation employeeinformation = new EmployeeInformation();
		employeeinformation.setId(100);
		employeeinformation.setDepartment("Corporate Governance");
		employeeinformation.setFirstName("Tom");
		employeeinformation.setLastName("Hildy");
		EmployeeInformationClient client = new EmployeeInformationClient();
		client.update(employeeinformation);
		assertNotNull(employeeinformation);
	}
	
	@Test
	public void testcreate(){
		EmployeeInformationClient client = new EmployeeInformationClient();
		EmployeeInformation employeeinformation = new EmployeeInformation();
		
		employeeinformation.setDepartment("Accounting");
		employeeinformation.setFirstName("Albert");
		employeeinformation.setLastName("Storm");
		
		employeeinformation = client.create(employeeinformation);
		
		assertNotNull(employeeinformation);
	}
	
	@Test
	public void testGet() {
		EmployeeInformationClient client = new EmployeeInformationClient();
		
		EmployeeInformation employeeinformation = client.get(1);
		
		System.out.println(employeeinformation);
		
		assertNotNull(employeeinformation);
	}
	

}
