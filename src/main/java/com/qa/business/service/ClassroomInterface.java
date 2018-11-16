package com.qa.business.service;

import com.qa.persistence.domain.Classroom;

public interface ClassroomInterface {
	String getAllClassrooms();
	String createNewClassroom(String classroom);
	String updateClassroom(Classroom classroom);
	String deleteClassroom(Classroom classroom);

}
