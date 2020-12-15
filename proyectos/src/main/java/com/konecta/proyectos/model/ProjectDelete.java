package com.konecta.proyectos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.konecta.proyectos.util.Util;

@Entity
@Table(name = "projectdelete")
public class ProjectDelete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "project")		
	private Project project;	
	@OneToOne
	@JoinColumn(name = "user")
	private User  user;
	@Transient
	@Temporal(TemporalType.DATE)	
	private Date dateDelete;
	private Long userdelete;
	
	
	public ProjectDelete() {
		this.dateDelete = Util.newDateToday();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateDelete() {
		return dateDelete;
	}

	public void setDateDelete(Date dateDelete) {
		this.dateDelete = dateDelete;
	}

	public Long getUserdelete() {
		return userdelete;
	}

	public void setUserdelete(Long userdelete) {
		this.userdelete = userdelete;
	}
	
	
	

}
