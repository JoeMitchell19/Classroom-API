package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONConversion;

@ApplicationScoped
@Alternative
public class ClassroomRepositoryMap implements ClassroomRepository {
	private HashMap<Long,Classroom> hmap = new HashMap<Long,Classroom>();
	private long id;

	@Override
	public String getAllClassrooms() {
		List<Classroom> allClassrooms = new ArrayList<Classroom>(hmap.values());
		return JSONConversion.getJSONFromObject(allClassrooms);
	}

	@Override
	public String createNewClassroom(String classroom) {
		id++;
		Classroom newClassroom = JSONConversion.getObjectForJSON(classroom, Classroom.class);
		hmap.put(id, newClassroom);
		return classroom;
	}

	@Override
	public String updateClassroom(Classroom classroom) {
		hmap.put(classroom.getId(), classroom);
		return JSONConversion.getJSONFromObject(classroom);
	}

	@Override
	public String deleteClassroom(Classroom classroom) {
		hmap.remove(classroom.getId(), classroom);
		if(hmap.containsValue(classroom)){
			System.out.println("Account has not been deleted");
			return "{\"message\": \"Account has not been deleted\"}";
		}
		else {
			System.out.println("Account has been deleted");
			return "{\"message\": \"Account has been deleted successfully\"}";
		}
	}
	
	public void initialiseMap() {
		Classroom c = new Classroom();
		c.setId(1);
		c.setClassroomID(1);
		c.setTrainer("Shafeeq");
	}

}
