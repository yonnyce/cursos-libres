package co.edu.ucentral.app.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.app.model.Curso;
import co.edu.ucentral.app.model.Estadisticas;
import co.edu.ucentral.app.model.EstudianteCurso;
import co.edu.ucentral.app.model.Evaluacion;
import co.edu.ucentral.app.model.Opcion;
import co.edu.ucentral.app.model.Pregunta;
import co.edu.ucentral.app.model.RespuestaEstudiante;
import co.edu.ucentral.app.model.ResultadosEstudiante;
import co.edu.ucentral.app.repository.EvaluacionRepository;
import co.edu.ucentral.app.repository.PreguntaRepository;
import co.edu.ucentral.app.servicio.common.config.exception.rest.UccCursosAppException;
import co.edu.ucentral.app.servicio.common.service.CommonServiceImpl;

@Service
public class EvaluacionServiceImpl extends CommonServiceImpl<Evaluacion, EvaluacionRepository>
		implements EvaluacionService {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private PreguntaRepository PreguntaRepository;

	@Override
	protected void verifyUniqueEntity(Evaluacion entity) {

		if (entity.getCurso().getExamen() != null) {
			throw new UccCursosAppException("Ya existe una evaluacion para este curso");
		}

	}

	@Override
	@Transactional(readOnly = false)
	public void registrarPreguntasEvaluacion(Long idCurso, List<Pregunta> preguntas) {
		Curso curso = this.cursoService.findById(idCurso);

		for (Pregunta pregunta : preguntas) {

			List<Opcion> opciones = pregunta.getOpciones();
			pregunta.setOpciones(null);

			pregunta.setEvaluacion(curso.getExamen());

			pregunta = PreguntaRepository.save(pregunta);

			for (Opcion opcion : opciones) {
				opcion.setPregunta(pregunta);
			}

			pregunta.setOpciones(opciones);

			this.PreguntaRepository.save(pregunta);
		}

	}

	@Override
	protected void mapUpdateableFields(Evaluacion newVersionEntity, Evaluacion oldVersionEntity) {

	}

	@Override
	@Transactional(readOnly = false)
	public void registrarRespuestasEstudiante(Long idCurso, Long idEstudiante, List<RespuestaEstudiante> respuestas) {

		Curso curso = this.cursoService.findById(idCurso);

		EstudianteCurso estudianteCurso = validarRegistroRespuestasEstudiante(curso, idEstudiante);

		for (RespuestaEstudiante respuestaEstudiante : respuestas) {
			respuestaEstudiante.setEstudianteCurso(estudianteCurso);
		}

		estudianteCurso.getRespuestasExamen().addAll(respuestas);

	}

	private EstudianteCurso validarRegistroRespuestasEstudiante(Curso curso, Long idEstudiante) {

		EstudianteCurso estudianteCurso = curso.getEstudiantes().stream().filter(e -> e.getIdEstudiante().equals(idEstudiante))
				.findAny().orElseThrow(() -> new UccCursosAppException(
						"No se encontro ningun estudiante en el curso con el identificador especificado"));

		if (!estudianteCurso.getRespuestasExamen().isEmpty()) {
			throw new UccCursosAppException("El estudiante ya respondio el examen");
		}

		return estudianteCurso;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RespuestaEstudiante> obtenerRespuestasEstudiante(Long idCurso, Long idEstudiante) {
		Curso curso = this.cursoService.findById(idCurso);

		EstudianteCurso estudianteCurso = this.obtenerEstudianteCurso(curso, idEstudiante);

		return estudianteCurso.getRespuestasExamen();
	}

	private EstudianteCurso obtenerEstudianteCurso(Curso curso, Long idEstudiante) {

		return curso.getEstudiantes().stream().filter(estudiante -> estudiante.getIdEstudiante().equals(idEstudiante))
				.findAny().orElseThrow(EntityNotFoundException::new);
	}

	@Override
	@Transactional(readOnly = true)
	public ResultadosEstudiante calificarExamenEstudiante(Long idCurso, Long idEstudiante) {
		Curso curso = this.cursoService.findById(idCurso);

		EstudianteCurso estudianteCurso = this.obtenerEstudianteCurso(curso, idEstudiante);

		List<RespuestaEstudiante> respuestasEstudiante = estudianteCurso.getRespuestasExamen();

		if (respuestasEstudiante.isEmpty()) {
			throw new UccCursosAppException("El estudiante indicado aun noresponde el examen");
		}

		Map<Long, Pregunta> preguntas = curso.getExamen().getPreguntas().stream()
				.collect(Collectors.toMap(Pregunta::getId, preg -> preg));

		int totalCorrectas = 0;

		for (RespuestaEstudiante respuesta : respuestasEstudiante) {
			Pregunta pregunta = preguntas.get(respuesta.getOpcion().getPregunta().getId());

			if (pregunta.respuestaCorrecta(respuesta.getOpcion())) {
				totalCorrectas++;
			}
		}

		double nota = (5.0 / (preguntas.size())) * totalCorrectas;

		ResultadosEstudiante resultado = new ResultadosEstudiante();
		resultado.setNota(nota);

		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResultadosEstudiante> obtenerTodosResultadosEstudiantes(Long idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estadisticas obtenerEstadisticasCurso(Long idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

}
