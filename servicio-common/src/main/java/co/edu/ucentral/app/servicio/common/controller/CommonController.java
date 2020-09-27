package co.edu.ucentral.app.servicio.common.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.ucentral.app.servicio.common.service.CommonService;

public class CommonController<E, S extends CommonService<E>> {

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
	public ResponseEntity<?> crear(@Valid @RequestBody E entity, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return this.validar(bindingResult);
		}

		entity = this.service.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	protected ResponseEntity<?> validar(BindingResult bindingResult) {
		Map<String, Object> errores = new HashMap<>();

		bindingResult.getFieldErrors().forEach(e -> {
			errores.put(e.getField(), e.getField() + " " + e.getDefaultMessage());
		});

		return ResponseEntity.badRequest().body(errores);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listar(@PathVariable Long id) {

		Optional<E> entity = this.service.findById(id);

		if (!entity.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(entity.get());
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		this.service.deleteById(id);
	}
}
