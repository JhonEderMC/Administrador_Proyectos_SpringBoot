package com.konecta.proyectos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.konecta.proyectos.model.Project;
import com.konecta.proyectos.model.ProjectUpdate;
import com.konecta.proyectos.repository.ProjectsRepository;
import com.konecta.proyectos.repository.ProjectsUpdateRepository;

import ch.qos.logback.core.util.SystemInfo;

@Service
public class ProjectsServiceImpl implements IProjectsService {
	
	
	
	@Autowired
	ProjectsRepository projectsRepository;
	
	@Autowired
	ProjectsUpdateRepository projectUpdateRepo;
	
	public Project findById(Long idProject) {
		Optional<Project> optional = projectsRepository.findById(idProject);
		
		if(optional.isPresent()) { 
			return optional.get();
		}
		return null;
	}
	
	@Override
	public void save(Project project) {		
			
		projectsRepository.save(project);		
	}
	
	@Override
	public List<Project> findAll() {		
		return projectsRepository.findAll();
	}

	@Override
	public void delete(Long idProject) {
		projectsRepository.deleteById(idProject);
		
	}

	@Override
	public List<Project> buscarByExample(Example<Project> example) {		
		return projectsRepository.findAll(example);
	}

	
	
	
	
	
	
	//code comment is for test with arraylist
	
	
	//private List<Project> list; 
	
	/*
	public ProjectsServiceImpl() {
		list =new ArrayList<Project>();
		list = generatedList();
	}*/	
	
	/*
	@Override
	public List<Project> findAll() {		
		return list;		
	}*/
	
	/*
	public Project findById(Long idProject) {
		for(Project project: list) {
			if(project.getId().equals(idProject)) {
				return project;
			}
		}
		return null;
	}
	*/	
	
	/*
	@Override
	public void save(Project project) {
		list.add(project);		
		System.out.println("Project is save\n"+project);		
	} */
	
	/*
	@Override
	public void delete(Long idProject) {
		System.out.println("Id proyecto eliminada: "+idProject);
		
	}*/

	/*
	public List<Project> generatedList(){
				
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Project p1 = new Project();
			p1.setId(1L);
			p1.setName("Levantamiento base de datos");
			p1.setArea("Bases de datos");
			p1.setBudget(1000d);
			p1.setManager("Elkin");
			p1.setTime(100l);
			p1.setCreate(sdf.parse("10-05-2020"));
			p1.setStart(sdf.parse("10-06-2020"));
			p1.setEnd(sdf.parse("11-07-2020"));
			p1.setState("Creado");
			
			Project p2 = new Project();
			p2.setId(2L);
			p2.setName("Levantamiento");
			p2.setArea("Bases ");
			p2.setBudget(1000d);
			p2.setManager("Elkin");
			p2.setTime(1009l);
			p2.setCreate(sdf.parse("10-05-2020"));
			p2.setStart(sdf.parse("11-06-2020"));
			p2.setEnd(sdf.parse("12-07-2020"));
			p2.setState("Cancelado");
			
			Project p3 = new Project();
			p3.setId(3L);
			p3.setName("pagina");
			p3.setArea("Desarollo");
			p3.setBudget(1000d);
			p3.setManager("Diego");
			p3.setTime(100l);
			p3.setCreate(sdf.parse("10-05-2020"));
			p3.setStart(sdf.parse("10-06-2020"));
			p3.setEnd(sdf.parse("11-07-2020"));
			p3.setState("En proceso");
			
			Project p4 = new Project();
			p4.setId(4L);
			p4.setName("Levantamiento base de datos");
			p4.setArea("Bases de datos");
			p4.setBudget(3000d);
			p4.setManager("Elkin");
			p4.setTime(200l);
			p4.setCreate(sdf.parse("10-05-2020"));
			p4.setStart(sdf.parse("10-06-2020"));
			p4.setEnd(sdf.parse("11-07-2020"));
			p4.setState("Finalizado");
			
			//List<Project> list = new ArrayList<Project>();
			list.add(p1);list.add(p2);
			list.add(p3);list.add(p4);
			return list;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;	
		
	} */

}
