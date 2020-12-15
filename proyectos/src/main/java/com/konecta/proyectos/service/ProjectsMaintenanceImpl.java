package com.konecta.proyectos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konecta.proyectos.model.ProjectDelete;
import com.konecta.proyectos.model.ProjectUpdate;
import com.konecta.proyectos.repository.ProjectsDeleteRepository;
import com.konecta.proyectos.repository.ProjectsUpdateRepository;

@Service
public class ProjectsMaintenanceImpl implements IProjectsMaintenance {

	@Autowired
	ProjectsUpdateRepository repoUpdate;
	
	@Autowired
	ProjectsDeleteRepository repoDelete;
	
	@Override
	public void SaveUpdate(ProjectUpdate projectUpdate) {
		repoUpdate.save(projectUpdate);
		
	}

	@Override
	public void saveDelete(ProjectDelete projectDelete) {		
		repoDelete.save(projectDelete);
	}
	
	@Override
	public void check_OFF() {
		repoDelete.setChecks_OFF();
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void check_ON() {
		repoDelete.setChecks_ON();
	}
	
	
	
	
	

}
