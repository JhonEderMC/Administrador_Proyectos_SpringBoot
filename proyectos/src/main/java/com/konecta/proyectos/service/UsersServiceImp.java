package com.konecta.proyectos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konecta.proyectos.model.User;
import com.konecta.proyectos.repository.UsersRepository;

@Service
public class UsersServiceImp implements IUsersService {

	@Autowired
	UsersRepository usersRepository;
	
	@Override
	public List<User> searchAllUsers() {		
		//return generatedList();
		return usersRepository.findAll();
	}

	@Override
	public User findUserById(Long id) {
		Optional<User> optional = usersRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	
	
	private List<User> generatedList(){
		User user1 = new User();
		user1.setId(1L);
		user1.setName("Diego");
		user1.setPassword("diego1234");
		user1.setState("Activo");
		
		
		User user2 = new User();
		user2.setId(2L);
		user2.setName("Sergio");
		user2.setPassword("1234");
		user2.setState("Inactivo");
		User user3 = new User();
		user3.setId(3L);
		user3.setName("Test");
		user3.setPassword("test");
		user3.setState("Activo");
		
		List<User> list = new ArrayList<User>();
		list.add(user1);list.add(user2);
		list.add(user3);
		return list;
	}

}
