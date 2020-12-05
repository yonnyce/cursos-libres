package co.edu.ucentral.app.usuario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.servicio.common.controller.CommonController;
import co.edu.ucentral.app.usuario.service.UsuarioService;
import co.edu.ucentral.commonusuarios.model.Usuario;

@RestController
public class UsuarioController extends CommonController<Usuario, UsuarioService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Usuario usuario, @PathVariable Long id) {

		Usuario usuarioBd = service.findById(id);
		usuarioBd.setNombre(usuario.getNombre());
		usuarioBd.setApellido(usuario.getApellido());
		usuarioBd.setEmail(usuario.getEmail());
		usuarioBd.setPassword(usuario.getPassword());
		usuarioBd.setRoles(usuario.getRoles());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioBd));
	}

	@GetMapping("/buscar-username")
	public ResponseEntity<?> verPorUsername(@RequestParam("username") String username) {
		Usuario usuario = service.findByUsername(username);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
}
