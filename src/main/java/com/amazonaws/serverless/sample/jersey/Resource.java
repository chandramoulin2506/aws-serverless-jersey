package com.amazonaws.serverless.sample.jersey;

import com.amazonaws.serverless.sample.jersey.model.Employee;
import com.amazonaws.serverless.sample.jersey.model.EmployeeDataAccessLayer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/employees")
public class Resource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEmployee(final Employee newEmployee) {
		if (newEmployee.getName() == null || newEmployee.getUserName() == null) {
			return Response.status(400).entity(new Error("Invalid name or UserName")).build();
		}

		Employee dbEmployee = newEmployee;
		dbEmployee.setId(UUID.randomUUID().toString());
		return Response.status(200).entity(dbEmployee).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee[] listEmployees(@QueryParam("limit") int limit) {
		if (limit < 1) {
			limit = 10;
		}

		Employee[] outputPets = new Employee[limit];

		for (int i = 0; i < limit; i++) {
			Employee employee = new Employee();
			employee.setId(UUID.randomUUID().toString());
			employee.setName(EmployeeDataAccessLayer.getRandomName());
			employee.setUserName(EmployeeDataAccessLayer.getRandomBreed());
			employee.setDateOfBirth(EmployeeDataAccessLayer.getRandomDoB());
			outputPets[i] = employee;
		}

		return outputPets;
	}

	@Path("/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeDetails() {
		Employee employee = new Employee();
		employee.setId(UUID.randomUUID().toString());
		employee.setUserName(EmployeeDataAccessLayer.getRandomBreed());
		employee.setDateOfBirth(EmployeeDataAccessLayer.getRandomDoB());
		employee.setName(EmployeeDataAccessLayer.getRandomName());
		return employee;
	}
}