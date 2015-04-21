package com.sgc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Endereco implements IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5064600058959015158L;
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private CEP cep;
	
	@Column
	private int numero;
	
	@Column
	private String complemento;
	
	@Override
	public long getId() {
		return id;
	}
	public CEP getCEP() {
		return cep;
	}
	public void setCEP(CEP cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
