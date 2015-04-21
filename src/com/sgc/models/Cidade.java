package com.sgc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3067651030553077504L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String Cidade;
	
	@ManyToOne
	private Estado estado;
	
	@Override
	public long getId() {
		return id;
	}
	
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}

}
