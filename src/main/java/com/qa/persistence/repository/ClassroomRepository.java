package com.qa.persistence.repository;

import com.qa.persistence.domain.Classroom;

public interface ClassroomRepository {

	String getAllClassrooms();
	String createNewClassroom(String classroom);
	String updateClassroom(Classroom classroom);
	String deleteClassroom(Classroom classroom);


}
