package com.konecta.proyectos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konecta.proyectos.model.ProjectUpdate;

public interface ProjectsUpdateRepository extends JpaRepository<ProjectUpdate, Long> {

}
