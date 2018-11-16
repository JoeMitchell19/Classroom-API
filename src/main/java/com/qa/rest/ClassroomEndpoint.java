package com.qa.rest;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomInterface;
import com.qa.persistence.domain.Classroom;

// An unsatisfied dependencies error (WELD-001408) occurred pointing to this class when running in wildfly.
//I have uploaded this version to github early so that this can act as a backup.

@Path("/Classroom")
public class ClassroomEndpoint {
	@Inject
	private ClassroomInterface classroomINT;
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return classroomINT.getAllClassrooms();
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createNewClassroom(String classroom) {
		return classroomINT.createNewClassroom(classroom);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(Classroom classroom) {
		return classroomINT.updateClassroom(classroom);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(Classroom classroom) {
		return classroomINT.deleteClassroom(classroom);
	}

}
