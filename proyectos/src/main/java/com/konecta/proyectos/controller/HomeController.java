package com.konecta.proyectos.controller;

import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.konecta.proyectos.model.User;
import com.konecta.proyectos.service.IUsersService;
import com.konecta.proyectos.util.Util;

@Controller
@RequestMapping("/")
public class HomeController {
	
	/**
	 * Para hace el login, inyecta una instancia de users, luego
	 */
	
	@Autowired
	IUsersService serviceUsers;
	
	
	@GetMapping("/")
	public String home() {
		
		return "formLogin";
	}
	
	@PostMapping("/login")
	public String home(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password,
		RedirectAttributes attributes, HttpSession session) {
		session.setAttribute("id", 5);
		//System.out.println("name: "+ name);
		//System.out.println("password: "+ password);
		String[] login = Util.checkLogin(name, password, serviceUsers.searchAllUsers(), session);		
		
		if(login[1].equals("False")){ //sign-off
			attributes.addFlashAttribute("msg", login[0]);			
			return"redirect:/";
		}		
		
		return "redirect:projects/index";
	}
	
	
	
}
