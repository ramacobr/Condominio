package com.sgc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais implements IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3752068172659454559L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String Pais;
	
	@Override
	public long getId() {
		return id;
	}
	
	public void setPais(String pais) {
		Pais = pais;
	}
	public String getPais() {
		return Pais;
	}
}
