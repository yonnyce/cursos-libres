package co.edu.ucentral.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.model.Estudiante;
import co.edu.ucentral.app.service.EstudianteService;
import co.edu.ucentral.app.servicio.common.controller.CommonController;

@RestController
public class EstudianteController extends CommonController<Estudiante, EstudianteService> {

	@GetMapping("/buscar-id")
	public ResponseEntity<?> findByUsername(@RequestParam("idEstudiante") Long idEstudiante) {

		Estudiante estudiante = this.service.findById(idEstudiante);

		return ResponseEntity.ok(estudiante);
	}

}
