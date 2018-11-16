package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;

public class ClassroomInterfaceImp implements ClassroomInterface {
	@Inject
	private ClassroomRepository repo;

	@Override
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	@Override
	public String createNewClassroom(String classroom) {
		return repo.createNewClassroom(classroom);
	}

	@Override
	public String updateClassroom(Classroom classroom) {
		return repo.updateClassroom(classroom);
	}

	@Override
	public String deleteClassroom(Classroom classroom) {
		return repo.deleteClassroom(classroom);
	}
}
