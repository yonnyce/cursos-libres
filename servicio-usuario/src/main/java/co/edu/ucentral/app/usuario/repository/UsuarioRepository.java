package co.edu.ucentral.app.usuario.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.edu.ucentral.commonusuarios.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	public Usuario findByUsername(String username);
}
