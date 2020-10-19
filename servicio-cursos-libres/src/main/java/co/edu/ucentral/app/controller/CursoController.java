package co.edu.ucentral.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.model.Curso;
import co.edu.ucentral.app.model.EstudianteCurso;
import co.edu.ucentral.app.model.Evaluacion;
import co.edu.ucentral.app.model.Pregunta;
import co.edu.ucentral.app.model.RespuestaEstudiante;
import co.edu.ucentral.app.service.CursoService;
import co.edu.ucentral.app.service.EvaluacionService;
import co.edu.ucentral.app.servicio.common.controller.CommonController;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

	@Autowired
	EvaluacionService evaluacionService;

	@PostMapping("/{idCurso}/evaluacion")
	public ResponseEntity<?> crearExamen(@Valid @RequestBody Evaluacion evaluacion,
			@PathVariable("idCurso") Long idCurso) {

		Curso curso = this.service.findById(idCurso);

		evaluacion.setCurso(curso);

		return ResponseEntity.ok(this.evaluacionService.save(evaluacion));
	}

	@PostMapping("/{idCurso}/evaluacion/preguntas")
	public ResponseEntity<?> agregarPreguntas(@Valid @RequestBody List<Pregunta> preguntas,
			@PathVariable("idCurso") Long idCurso) {
		this.evaluacionService.registrarPreguntasEvaluacion(idCurso, preguntas);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{idCurso}/evaluacion")
	public ResponseEntity<?> consultarEvaluacion(@PathVariable("idCurso") Long idCurso) {

		Curso curso = this.service.findById(idCurso);

		return ResponseEntity.ok(this.service.save(curso).getExamen());
	}

	@PostMapping("/{idCurso}/estudiantes")
	public ResponseEntity<?> asociarEstudiante(@Valid @RequestBody EstudianteCurso estudiante,
			@PathVariable("idCurso") Long idCurso) {

		Curso curso = this.service.findById(idCurso);

		estudiante.setCurso(curso);

		curso.getEstudiantes().add(estudiante);

		this.service.save(curso);

		return ResponseEntity.ok().build();
	}

	@GetMapping("/{idCurso}/estudiantes/{idEstudiante}/respuestas")
	public ResponseEntity<?> consultarRespuestasEstudiante(@PathVariable("idCurso") Long idCurso,
			@PathVariable("idEstudiante") Long idEstudiante) {

		return ResponseEntity.ok(this.evaluacionService.obtenerRespuestasEstudiante(idCurso, idEstudiante));
	}

	@GetMapping("/{idCurso}/estudiantes")
	public ResponseEntity<?> obtenerEstudiantes(@PathVariable("idCurso") Long idCurso) {

		Curso curso = this.service.findById(idCurso);

		return ResponseEntity.ok(curso.getEstudiantes());
	}

	@PostMapping("/{idCurso}/estudiantes/{idEstudiante}/evaluacion/respuestas")
	public ResponseEntity<?> responderExamen(@RequestBody List<RespuestaEstudiante> respuestas,
			@PathVariable("idCurso") Long idCurso, @PathVariable("idEstudiante") Long idEstudiante) {

		this.evaluacionService.registrarRespuestasEstudiante(idCurso, idEstudiante, respuestas);

		return ResponseEntity.ok().build();
	}

	@GetMapping("/{idCurso}/estudiantes/{idEstudiante}/evaluacion/respuestas")
	public ResponseEntity<?> obtenerRespuestas(@RequestBody List<RespuestaEstudiante> respuestas,
			@PathVariable("idCurso") Long idCurso, @PathVariable("idEstudiante") Long idEstudiante) {

		this.evaluacionService.registrarRespuestasEstudiante(idCurso, idEstudiante, respuestas);

		return ResponseEntity.ok().build();
	}

	@GetMapping("/{idCurso}/estudiantes/{idEstudiante}/evaluacion/calificar")
	public ResponseEntity<?> calificarExamenEstudiante(@PathVariable("idCurso") Long idCurso,
			@PathVariable("idEstudiante") Long idEstudiante) {

		return ResponseEntity.ok(this.evaluacionService.calificarExamenEstudiante(idCurso, idEstudiante));
	}

}
