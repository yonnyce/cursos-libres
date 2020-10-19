package co.edu.ucentral.app.service;

import java.util.List;

import co.edu.ucentral.app.model.Curso;
import co.edu.ucentral.app.model.EstudianteCurso;
import co.edu.ucentral.app.servicio.common.service.CommonService;

public interface CursoService extends CommonService<Curso> {

	List<Curso> obtenerCursosDepartamento(Long idDepartamento);

	List<EstudianteCurso> obtenerEstudiantesDepartamento(Long idDepartamento);

}
