package co.edu.ucentral.app.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.model.Evaluacion;
import co.edu.ucentral.app.repository.EvaluacionRepository;
import co.edu.ucentral.app.servicio.common.config.exception.rest.UccCursosAppException;
import co.edu.ucentral.app.servicio.common.service.CommonServiceImpl;

@Service
public class EvaluacionServiceImpl extends CommonServiceImpl<Evaluacion, EvaluacionRepository>
		implements EvaluacionService {

	@Override
	protected void verifyUniqueEntity(Evaluacion entity) {

		if (entity.getCurso().getExamen() != null) {
			throw new UccCursosAppException("Ya existe una evaluacion para este curso");
		}

	}

	@Override
	protected void mapUpdateableFields(Evaluacion newVersionEntity, Evaluacion oldVersionEntity) {
		// TODO Auto-generated method stub

	}

}
