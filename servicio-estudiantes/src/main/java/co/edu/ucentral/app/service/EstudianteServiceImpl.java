package co.edu.ucentral.app.service;

import co.edu.ucentral.app.model.Estudiante;
import co.edu.ucentral.app.repository.EstudianteRespository;
import co.edu.ucentral.app.servicio.common.service.CommonServiceImpl;

public class EstudianteServiceImpl extends CommonServiceImpl<Estudiante, EstudianteRespository>
		implements EstudianteService {

	@Override
	protected void verifyUniqueEntity(Estudiante entity) {

	}

	@Override
	protected Estudiante mapUpdateableFields(Estudiante newVersionEntity, Estudiante oldVersionEntity) {
		return null;
	}

}
