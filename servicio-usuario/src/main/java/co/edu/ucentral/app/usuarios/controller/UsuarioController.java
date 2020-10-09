package co.edu.ucentral.app.usuarios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.ucentral.app.commonusuarios.model.Usuario;
import co.edu.ucentral.app.servicio.common.controller.CommonController;
import co.edu.ucentral.app.usuarios.service.UsuarioService;

@Controller
public class UsuarioController extends CommonController<Usuario, UsuarioService> {

	@GetMapping("/buscar-username")
	public ResponseEntity<?> findByUsername(@RequestParam String username) {

		Usuario usuario = this.service.buscarPorNombre(username);

		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}

}
