package co.edu.ucentral.app.controller;

import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.app.model.Facultad;
import co.edu.ucentral.app.service.FacultadService;
import co.edu.ucentral.app.servicio.common.controller.CommonController;

@RestController
public class FacultadController extends CommonController<Facultad, FacultadService> {

}
