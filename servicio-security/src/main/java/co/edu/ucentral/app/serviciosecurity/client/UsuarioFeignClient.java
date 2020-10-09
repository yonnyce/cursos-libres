package co.edu.ucentral.app.serviciosecurity.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.ucentral.app.commonusuarios.model.Usuario;

@FeignClient("servicio-usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/buscar-username")
	Usuario findByUsername(String username);

}
