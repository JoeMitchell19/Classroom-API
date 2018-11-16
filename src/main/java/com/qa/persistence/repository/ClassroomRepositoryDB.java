package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONConversion;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

@Default
@Transactional(SUPPORTS)
public class ClassroomRepositoryDB implements ClassroomRepository {
	@PersistenceContext(unitName = "Primary")
	private EntityManager em;
	
	public String getAllClassrooms() {
		TypedQuery<Classroom> selectAll = em.createQuery("SELECT c from Classroom c",Classroom.class);
		return JSONConversion.getJSONFromObject(selectAll);
	}
	
	@Transactional(REQUIRED)
	public String createNewClassroom(String classroom) {
		Classroom newClassroom = JSONConversion.getObjectForJSON(classroom,Classroom.class);
		em.persist(newClassroom);
		return "{\"message\": \"A new classroom has been successfully created\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateClassroom(Classroom classroom) {
		long id = classroom.getId();
		Classroom updatedClassroom = em.find(Classroom.class,id);
		updatedClassroom.updateAll(updatedClassroom);
		em.merge(updatedClassroom);
		return "{\"message\": \"A classroom has been successfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteClassroom(Classroom classroom) {
		if(classroom != null) {
			em.remove(classroom);
		}
		return "{\"message\": \"A classroom has been successfully deleted\"}";
		
	}
	

}
