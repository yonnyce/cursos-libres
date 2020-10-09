package co.edu.ucentral.app.usuarios.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.app.commonusuarios.model.Usuario;
import co.edu.ucentral.app.servicio.common.service.CommonServiceImpl;
import co.edu.ucentral.app.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository> implements UsuarioService {

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarPorNombre(String username) {
		return this.repository.findByUsername(username);
	}

	@Override
	protected void verifyUniqueEntity(Usuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Usuario mapUpdateableFields(Usuario newVersionEntity, Usuario oldVersionEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
