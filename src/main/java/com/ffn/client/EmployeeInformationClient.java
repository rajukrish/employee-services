package com.ffn.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ffn.model.EmployeeInformation;

public class EmployeeInformationClient {

	private Client client;
	
	public EmployeeInformationClient(){
		client = ClientBuilder.newClient();
	}
	
	public EmployeeInformation get(int id){
		
		//builiding the URL http://localhost:8080/employee-services/emp/1
		WebTarget target = client.target("http://localhost:8080/employee-services/");
		
		EmployeeInformation response = target.path("emp/" + id).request().get(EmployeeInformation.class);
		
		return response;
		
	}

	public List<EmployeeInformation> get (){
		WebTarget target = client.target("http://localhost:8080/employee-services/");
		List<EmployeeInformation> response = target.path("emp").request(MediaType.APPLICATION_JSON).get(new GenericType<List<EmployeeInformation>>(){});
		
		return response;
	}
	
	public EmployeeInformation create(EmployeeInformation employeeinformation) {
		
		WebTarget target = client.target("http://localhost:8080/employee-services/");
		
		Response response = target.path("emp/employee").request(MediaType.APPLICATION_JSON).post(Entity.entity(employeeinformation, MediaType.APPLICATION_JSON));
		
		return response.readEntity(EmployeeInformation.class);
	}

	public EmployeeInformation update(EmployeeInformation employeeinformation) {
		
		WebTarget target = client.target("http://localhost:8080/employee-services/");
		Response response = target.path("emp/" + employeeinformation.getId()).request(MediaType.APPLICATION_JSON).put(Entity.entity(employeeinformation, MediaType.APPLICATION_JSON));
		
		return response.readEntity(EmployeeInformation.class);
		
	}

	public void delete(int employeeId) {
		WebTarget target = client.target("http://localhost:8080/employee-services/");
		
		Response response = target.path("emp/" + employeeId).request(MediaType.APPLICATION_JSON).delete();
		
		System.out.println(response.getStatus());
	}

	
	
}
