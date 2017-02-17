package com.ffn;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ffn.model.EmployeeInformation;
import com.ffn.model.User;
import com.ffn.repository.EmployeeRepository;
import com.ffn.repository.EmployeeRepositoryStub;

@Path("emp")
public class EmployeeResource {

	private EmployeeRepository employeerepository = new EmployeeRepositoryStub();

	@Path("{employeeId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(EmployeeInformation employeeinformation){
		
		System.out.println(employeeinformation.getId());
		System.out.println(employeeinformation.getFirstName());
		System.out.println(employeeinformation.getLastName());
		
		employeeinformation = employeerepository.update(employeeinformation);
		return Response.ok().entity(employeeinformation).build();
	}
	
	@Path("employee") //http://localhost:8080/employee-services/emp/employee submit employee information
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeInformation createEmployee(EmployeeInformation employeeinformation){
		
		System.out.println(employeeinformation.getId());
		System.out.println(employeeinformation.getFirstName());
		System.out.println(employeeinformation.getLastName());
		System.out.println(employeeinformation.getDepartment());
		
		//EmployeeInformation employeeinformation = new EmployeeInformation();
		
		//employeeinformation.setId(Integer.parseInt(formParams.getFirst("Id")));
		//employeeinformation.setFirstName(formParams.getFirst("FirstName"));
		//employeeinformation.setLastName(formParams.getFirst("LastName"));
		//employeeinformation.setDepartment(formParams.getFirst("Department"));
		
		employeerepository.create(employeeinformation);
		return employeeinformation;
	}
	
	@Path("getemployees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeInformation> getAllEmployees(){
		return employeerepository.findAllEmployees();
	}
	
	@Path("{employeeId}") //http://localhost:8080/employee-services/emp/1 -- employee information based on ID
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeInformation getEmployee(@PathParam ("employeeId") int employeeId) {
		return employeerepository.findEmployee(employeeId);
	}
	
	@Path("{department}/user") //http://localhost:8080/employee-services/emp/finance/user -- employees in a department
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getDeptEmployee(@PathParam ("department") String department) {
		return employeerepository.getDeptEmployees(department).getUser();
	}
}
