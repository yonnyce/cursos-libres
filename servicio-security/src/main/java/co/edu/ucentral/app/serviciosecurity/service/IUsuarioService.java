package co.edu.ucentral.app.serviciosecurity.service;

import co.edu.ucentral.commonusuarios.model.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
}
