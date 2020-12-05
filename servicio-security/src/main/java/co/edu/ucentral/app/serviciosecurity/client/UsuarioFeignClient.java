package co.edu.ucentral.app.serviciosecurity.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.ucentral.commonusuarios.model.Usuario;

@FeignClient("servicio-usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/buscar-username")
	public Usuario findByUsername(@RequestParam String username);
}
