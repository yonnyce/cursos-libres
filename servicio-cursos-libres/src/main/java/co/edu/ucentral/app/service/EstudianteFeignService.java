package co.edu.ucentral.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.ucentral.app.model.Estudiante;

@FeignClient("servicio-estudiantes")
public interface EstudianteFeignService {

	@GetMapping("/buscar-id")
	Estudiante buscarPorId(Long idEstudiante);

}
