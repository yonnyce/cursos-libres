package co.edu.ucentral.app.usuarios.service;

import co.edu.ucentral.app.commonusuarios.model.Usuario;
import co.edu.ucentral.app.servicio.common.service.CommonService;

public interface UsuarioService extends CommonService<Usuario> {

	Usuario buscarPorNombre(String username);

}
