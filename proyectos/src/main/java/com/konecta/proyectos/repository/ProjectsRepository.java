package com.konecta.proyectos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konecta.proyectos.model.Project;

public interface ProjectsRepository extends JpaRepository<Project, Long> {

}
