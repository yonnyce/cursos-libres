package co.edu.ucentral.app.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.model.Estudiante;
import co.edu.ucentral.app.repository.EstudianteRespository;
import co.edu.ucentral.app.servicio.common.service.CommonServiceImpl;

@Service
public class EstudianteServiceImpl extends CommonServiceImpl<Estudiante, EstudianteRespository>
		implements EstudianteService {

	@Override
	protected void verifyUniqueEntity(Estudiante entity) {

	}

	@Override
	protected void mapUpdateableFields(Estudiante newVersionEntity, Estudiante oldVersionEntity) {
		
	}

}
