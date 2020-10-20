package co.edu.ucentral.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.model.Departamento;
import co.edu.ucentral.app.model.Facultad;
import co.edu.ucentral.app.service.FacultadService;
import co.edu.ucentral.app.servicio.common.controller.CommonController;

@RestController
public class FacultadController extends CommonController<Facultad, FacultadService> {

	@PostMapping("{idFacultad}/departamentos")
	ResponseEntity<?> registrarDepartamento(@Valid @RequestBody Departamento departamento,
			@PathVariable("idFacultad") Long idFacultad) {

		Facultad facultad = this.service.findById(idFacultad);
		facultad.getDepartamentos().add(departamento);
		this.service.save(facultad);

		return ResponseEntity.ok().build();

	}

	@GetMapping("{idFacultad}/departamentos")
	ResponseEntity<?> consultarDepartamentos(@Valid @RequestBody Departamento departamento,
			@PathVariable("idFacultad") Long idFacultad) {

		Facultad facultad = this.service.findById(idFacultad);

		return ResponseEntity.ok(facultad.getDepartamentos());

	}

}
