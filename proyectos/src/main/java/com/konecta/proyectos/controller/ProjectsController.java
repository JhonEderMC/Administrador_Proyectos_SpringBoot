package com.konecta.proyectos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionIdListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.konecta.proyectos.model.Project;
import com.konecta.proyectos.model.ProjectDelete;
import com.konecta.proyectos.model.ProjectUpdate;
import com.konecta.proyectos.repository.ProjectsUpdateRepository;
import com.konecta.proyectos.service.IProjectsMaintenance;
import com.konecta.proyectos.service.IProjectsService;
import com.konecta.proyectos.service.IUsersService;

@Controller
@RequestMapping("/projects")
public class ProjectsController {
	
	private Long idSession;
	
	@Autowired
	IProjectsService serviceProjects;
	
	@Autowired
	IUsersService serviceUsers;
	
	@Autowired
	IProjectsMaintenance serviceMaintenance;
	
	
	
	@GetMapping("/index")
	public String showList(Model model, HttpSession  session, Pageable page) {
		if( session.getAttribute("id") == null) { //there were login
			return "formLogin";
		}
		
		//System.out.println("Session:" +session.getAttribute("id"));//test session ID
		idSession= (Long) session.getAttribute("id");
		model.addAttribute("user", serviceUsers.findUserById(idSession));		
		model.addAttribute("projects", serviceProjects.findAll());		
		return "projects/listProjects";
	}
	
	@GetMapping("/create")
	public String create(Project project, Model model) {
		//model.addAttribute("users", serviceUsers.searchAllUsers()); // look same down
		if( idSession == null || idSession== 0) { //there were not login
			return "formLogin";
		}		
		// preselected user on view
		model.addAttribute("user", serviceUsers.findUserById(idSession));
		
		return "projects/formProject";
	}
	
	@PostMapping("/save")
	public String save(Project project, BindingResult result, RedirectAttributes attributes,
			ProjectUpdate projectUpdate) {
		if(result.hasErrors()) { //errors
			for (ObjectError err:result.getAllErrors()) { //print errors in console
				System.out.println("Error:"+err.getDefaultMessage());				
			}
			return "projects/formProject";
		}
		//save user in class (only had id)
		project.setUser(serviceUsers.findUserById(project.getUser().getId()));		
		//System.out.println("project: "+project);//test
		//System.out.println("User: "+ project.getUser());
		
		if (project.getId()!= null) { //it's a update
			projectUpdate.setProject(project);		 
			projectUpdate.setUser(project.getUser());
			projectUpdate.setUsermodifico(idSession);
			//System.out.println("Update");
			//System.out.println(projectUpdate);
			serviceMaintenance.SaveUpdate(projectUpdate);
		}
		
		//System.out.println(projectUpdate);

		serviceProjects.save(project);
		attributes.addFlashAttribute("msg", "Proyecto guardado");
		return "redirect:/projects/index";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long idProject, RedirectAttributes addAttributes,
			ProjectDelete projectDelete) {
		
		// first keep before of delete
		Project project = serviceProjects.findById(idProject);
		projectDelete.setProject(project);
		projectDelete.setUser(project.getUser());
		projectDelete.setUserdelete(idSession); //user deleted it
		serviceMaintenance.saveDelete(projectDelete);
		serviceMaintenance.check_OFF();
		//delete it
		serviceProjects.delete(idProject);
		serviceMaintenance.check_ON();
		addAttributes.addFlashAttribute("msg", "Proyecto eliminado");
		return "redirect:/projects/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long idProject, Model model) {
		Project project = serviceProjects.findById(idProject);
		model.addAttribute("project", project);
		model.addAttribute("user", project.getUser());
		return "projects/formProject";
	}
	
	@GetMapping("/search")
	public String search(@ModelAttribute("projectSearch") Project projectSearch, Model model) {
		//projectSearch.setCreate(null); //no search for this param
		/* same with init data binder (look down (implement with init binder))
		if(projectSearch.getName()=="") {
			projectSearch.setName(null);
		}
		if(projectSearch.getState()=="") {
			projectSearch.setState(null);;
		}*/
		
		
//		System.out.println("busqueda: "+projectSearch);
//		System.out.println("user: "+projectSearch.getUser());
		//define how will be search by this param
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
				//Where name like %?%		
		Example<Project> example = Example.of(projectSearch,matcher);
		model.addAttribute("projects", serviceProjects.buscarByExample(example));
		return "projects/listProjects";
	}
	
	/**
	 * Method to add attributes for all methods	 * 
	 */
	@ModelAttribute
	public void setGenerics(Model model) {
		//model.addAttribute("users", serviceUsers.searchAllUsers());		
		model.addAttribute("users", serviceUsers.searchAllUsers());
		//for add values to search
		Project projectSearch = new Project();
		model.addAttribute("projectSearch", projectSearch);
	}
	
	/**
	 * Method for custom date format from project form
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		//Custom dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
		//When the Strings are empty then set them as null
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));		
	}
	

}
