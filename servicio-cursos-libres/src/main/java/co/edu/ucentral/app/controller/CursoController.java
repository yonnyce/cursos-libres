package co.edu.ucentral.app.controller;

import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.model.Curso;
import co.edu.ucentral.app.service.CursoService;
import co.edu.ucentral.app.servicio.common.controller.CommonController;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

}
