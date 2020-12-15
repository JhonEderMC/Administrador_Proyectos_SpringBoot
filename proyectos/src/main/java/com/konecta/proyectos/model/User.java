package com.konecta.proyectos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents a that manages projects. 
 *
 */
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
	private String state;
	
	//private List<Project> projects;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	//for watch: Testing 
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password +", state="+ state + "]";
	}
	
	
	
	
	
	

}
