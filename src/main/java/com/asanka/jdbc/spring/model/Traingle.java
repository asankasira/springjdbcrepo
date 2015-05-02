package com.asanka.jdbc.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Traingle implements Serializable {

	private static final long serialVersionUID = 8365119867952328246L;
	
	@Id
	private Integer Id;
	private String name;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
