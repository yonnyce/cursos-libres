package co.edu.ucentral.app.usuario.service;

import co.edu.ucentral.app.servicio.common.service.CommonService;
import co.edu.ucentral.commonusuarios.model.Usuario;

public interface UsuarioService extends CommonService<Usuario> {
	public Usuario findByUsername(String username);
}
