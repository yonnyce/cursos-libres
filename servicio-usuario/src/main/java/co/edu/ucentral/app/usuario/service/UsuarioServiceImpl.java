package co.edu.ucentral.app.usuario.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.app.servicio.common.service.CommonServiceImpl;
import co.edu.ucentral.app.usuario.repository.UsuarioRepository;
import co.edu.ucentral.commonusuarios.model.Usuario;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository> implements UsuarioService {

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	protected void verifyUniqueEntity(Usuario entity) {

	}

	@Override
	protected void mapUpdateableFields(Usuario newVersionEntity, Usuario oldVersionEntity) {

	}

}
