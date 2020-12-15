package com.konecta.proyectos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.konecta.proyectos.model.ProjectDelete;

public interface ProjectsDeleteRepository extends JpaRepository<ProjectDelete, Long> {
	
	@Query(value = "SET FOREIGN_KEY_CHECKS = 0;", nativeQuery = true)	
	 void setChecks_OFF();
	@Query(value = "SET FOREIGN_KEY_CHECKS = 1;", nativeQuery = true)	
	 void setChecks_ON();
}
