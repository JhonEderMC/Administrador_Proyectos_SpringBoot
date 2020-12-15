package com.konecta.proyectos.service;

import com.konecta.proyectos.model.ProjectDelete;
import com.konecta.proyectos.model.ProjectUpdate;

public interface IProjectsMaintenance {
	
	void SaveUpdate(ProjectUpdate projectUpdate);
	void saveDelete(ProjectDelete projectDelete);
	void check_OFF(); //Estaba embalado :(
	void check_ON(); //Pero funciona por ahora :)

}
