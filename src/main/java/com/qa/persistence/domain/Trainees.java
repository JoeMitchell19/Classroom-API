package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainees {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private long traineeID;
	@Column(length = 200)
	private String trainee;
	
	public Trainees() {}

	public long getId() {
		return id;
	}

	public String getTrainee() {
		return trainee;
	}

	public void setTrainee(String trainee) {
		this.trainee = trainee;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(long traineeID) {
		this.traineeID = traineeID;
	}
	
	public void addTrainees(long id, long traineeID, String traineeName) {
		this.id = id;
		this.traineeID = traineeID;
		this.trainee = traineeName;
	}
	

}
