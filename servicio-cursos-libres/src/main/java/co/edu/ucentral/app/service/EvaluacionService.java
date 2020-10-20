package co.edu.ucentral.app.service;

import java.util.List;

import co.edu.ucentral.app.model.Estadisticas;
import co.edu.ucentral.app.model.EstudianteCurso;
import co.edu.ucentral.app.model.Evaluacion;
import co.edu.ucentral.app.model.Pregunta;
import co.edu.ucentral.app.model.RespuestaEstudiante;
import co.edu.ucentral.app.model.ResultadosEstudiante;
import co.edu.ucentral.app.servicio.common.service.CommonService;

public interface EvaluacionService extends CommonService<Evaluacion> {

	void registrarPreguntasEvaluacion(Long idCurso, List<Pregunta> preguntas);

	void registrarRespuestasEstudiante(Long idCurso, Long idEstudiante, List<RespuestaEstudiante> respuestas);

	List<RespuestaEstudiante> obtenerRespuestasEstudiante(Long idCurso, Long idEstudiante);

	ResultadosEstudiante calificarExamenEstudiante(Long idCurso, Long idEstudiante);

	List<ResultadosEstudiante> obtenerTodosResultadosEstudiantes(Long idCurso);

	Estadisticas obtenerEstadisticasCurso(Long idCurso);

	List<EstudianteCurso> estudiantesAprobadosCurso(Long idCurso);

	List<EstudianteCurso> estudiantesReprobadosCurso(Long idCurso);

}
