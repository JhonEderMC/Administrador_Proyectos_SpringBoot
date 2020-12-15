package com.konecta.proyectos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konecta.proyectos.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {

}
