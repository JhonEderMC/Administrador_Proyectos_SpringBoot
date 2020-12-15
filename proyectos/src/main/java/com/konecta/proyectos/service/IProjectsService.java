package com.konecta.proyectos.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.konecta.proyectos.model.Project;

public interface IProjectsService {
	
	 List<Project> findAll();
	void save(Project project);
	void delete(Long idProject);
	Project findById(Long idProject);
	List<Project> buscarByExample(Example<Project> example);


}
