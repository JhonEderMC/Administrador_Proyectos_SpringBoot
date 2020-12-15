package com.konecta.proyectos.service;

import java.util.List;

import com.konecta.proyectos.model.User;

public interface IUsersService {
	
	List<User> searchAllUsers();
	User findUserById(Long id);
		
	

}
