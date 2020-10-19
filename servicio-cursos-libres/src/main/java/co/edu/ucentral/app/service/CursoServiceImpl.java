package co.edu.ucentral.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.model.Curso;
import co.edu.ucentral.app.model.EstudianteCurso;
import co.edu.ucentral.app.repository.CursoRepository;
import co.edu.ucentral.app.servicio.common.config.exception.rest.UccCursosAppException;
import co.edu.ucentral.app.servicio.common.service.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Override
	protected void verifyUniqueEntity(Curso entity) {

		Optional<Curso> cursoOpt = this.repository.findByNombre(entity.getNombre());

		if (cursoOpt.isPresent() && !cursoOpt.get().getId().equals(entity.getId())) {
			throw new UccCursosAppException("Ya existe un curso con el nombre ingresado");
		}

	}

	@Override
	protected void mapUpdateableFields(Curso newVersionEntity, Curso oldVersionEntity) {
		oldVersionEntity.setNombre(newVersionEntity.getNombre());
	}

	@Override
	public List<Curso> obtenerCursosDepartamento(Long idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstudianteCurso> obtenerEstudiantesDepartamento(Long idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

}
