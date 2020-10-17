package co.edu.ucentral.app.service;

import java.util.List;

import co.edu.ucentral.app.model.Evaluacion;
import co.edu.ucentral.app.model.RespuestaEstudiante;
import co.edu.ucentral.app.servicio.common.service.CommonService;

public interface EvaluacionService extends CommonService<Evaluacion> {

	void registrarRespuestasEstudiante(List<RespuestaEstudiante> respuestas);

}
