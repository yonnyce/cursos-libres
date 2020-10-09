package co.edu.ucentral.app.service;

import co.edu.ucentral.app.model.Curso;
import co.edu.ucentral.app.repository.CursoRepository;
import co.edu.ucentral.app.servicio.common.service.CommonServiceImpl;

public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Override
	protected void verifyUniqueEntity(Curso entity) {
		//Verificar unico 
		
	}

	@Override
	protected Curso mapUpdateableFields(Curso newVersionEntity, Curso oldVersionEntity) {
		
		return null;
	}

}
