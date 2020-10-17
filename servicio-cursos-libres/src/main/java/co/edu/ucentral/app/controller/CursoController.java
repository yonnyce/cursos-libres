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

		Curso curso = this.service.findById(idCurso);

		for (Pregunta pregunta : preguntas) {
			pregunta.setEvaluacion(curso.getExamen());
		}

		curso.getExamen().getPreguntas().addAll(preguntas);

		return ResponseEntity.ok(this.service.save(curso).getExamen());
	}

	@PostMapping("/{idCurso}/estudiantes")
	public ResponseEntity<?> asociarEstudiante(@Valid @RequestBody EstudianteCurso estudiante,
			@PathVariable("idCurso") Long idCurso) {

		Curso curso = this.service.findById(idCurso);

		estudiante.setCurso(curso);

		curso.getEstudiantes().add(estudiante);

		return ResponseEntity.ok(this.service.save(curso));
	}

	@GetMapping("/{idCurso}/estudiantes")
	public ResponseEntity<?> obtenerEstudiantes(@PathVariable("idCurso") Long idCurso) {

		Curso curso = this.service.findById(idCurso);

		return ResponseEntity.ok(curso.getEstudiantes());
	}

	@PostMapping("/{idCurso}/estudiantes/{idEstudiante}/responder-examen")
	public ResponseEntity<?> responderExamen(@RequestBody List<RespuestaEstudiante> respuestas,
			@PathVariable("idCurso") Long idCurso, @PathVariable("idEstudiante") Long idEstudiante) {

		Curso curso = this.service.findById(idCurso);

		return ResponseEntity.ok(curso.getEstudiantes());
	}

}
