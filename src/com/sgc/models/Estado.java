package com.sgc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estado implements IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8789317694333707259L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String estado;

	@ManyToOne
	private Pais pais;

	@Override
	public long getId() {
		return id;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}
}
