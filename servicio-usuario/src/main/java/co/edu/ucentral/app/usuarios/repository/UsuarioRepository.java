package co.edu.ucentral.app.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.app.commonusuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);

}
