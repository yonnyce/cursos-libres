package co.edu.ucentral.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.model.Curso;
import co.edu.ucentral.app.model.EstudianteCurso;
import co.edu.ucentral.app.model.Evaluacion;
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

	@PostMapping("/{idCurso}/estudiante")
	public ResponseEntity<?> asociarEstudiante(@Valid @RequestBody EstudianteCurso estudiante,
			@PathVariable("idCurso") Long idCurso) {

		Curso curso = this.service.findById(idCurso);

		estudiante.setCurso(curso);

		curso.getEstudiantes().add(estudiante);

		return ResponseEntity.ok(this.service.save(curso));
	}

}
