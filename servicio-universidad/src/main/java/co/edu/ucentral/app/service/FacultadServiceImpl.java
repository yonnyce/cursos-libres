package co.edu.ucentral.app.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.model.Facultad;
import co.edu.ucentral.app.repository.FacultadRespository;
import co.edu.ucentral.app.servicio.common.config.exception.rest.UccCursosAppException;
import co.edu.ucentral.app.servicio.common.service.CommonServiceImpl;

@Service
public class FacultadServiceImpl extends CommonServiceImpl<Facultad, FacultadRespository> implements FacultadService {

	@Override
	protected void verifyUniqueEntity(Facultad entity) {
		if (this.repository.findByNombre(entity.getNombre()).isPresent()) {
			throw new UccCursosAppException("Ya existe una facultad con el nombre ingresado");
		}
	}

	@Override
	protected void mapUpdateableFields(Facultad newVersionEntity, Facultad oldVersionEntity) {

		oldVersionEntity.setNombre(newVersionEntity.getNombre());
	}

}
