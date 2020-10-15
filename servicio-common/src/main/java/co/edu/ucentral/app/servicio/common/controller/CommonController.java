package co.edu.ucentral.app.servicio.common.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;
import co.edu.ucentral.app.servicio.common.service.CommonService;

public class CommonController<E extends EntidadBase, S extends CommonService<E>> {

	@Autowired
	protected S service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@GetMapping("/pagina")
	public ResponseEntity<?> listar(Pageable pageable) {
		return ResponseEntity.ok(this.service.findAll(pageable));
	}

	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody E entity) {

		entity = this.service.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listar(@PathVariable Long id) {

		E entity = this.service.findById(id);

		return ResponseEntity.ok(entity);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody E entity, @PathVariable Long id) {

		if (!id.equals(entity.getId())) {
			entity.setId(id);
		}

		entity = this.service.update(entity);

		return ResponseEntity.ok(entity);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		this.service.deleteById(id);
	}
}
