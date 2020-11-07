package co.edu.ucentral.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.ucentral.app.model.Estudiante;

@FeignClient(name = "servicio-estudiantes",url = "localhost:8090/api/estudiantes")
public interface EstudianteFeignService {

	@GetMapping("/buscar-id")
	Estudiante buscarPorId(@RequestParam("idEstudiante") Long idEstudiante);

}
