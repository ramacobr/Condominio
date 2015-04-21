package com.sgc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="users")
@XmlRootElement
public class User implements IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5575273914780072185L;
	
	@XmlElement
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@XmlElement
	@Column(unique=true)
	private String login;
	@XmlElement
	@Column
	private String name;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("id=%d, ", id));
		sb.append(String.format("name=%s, ", name));
		sb.append(String.format("login=%s",login));
		return sb.toString();
	}
}
