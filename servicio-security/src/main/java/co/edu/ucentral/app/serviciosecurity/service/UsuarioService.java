package co.edu.ucentral.app.serviciosecurity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.ucentral.app.commonusuarios.model.Usuario;
import co.edu.ucentral.app.serviciosecurity.client.UsuarioFeignClient;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioFeignClient UsuarioFeignClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = this.UsuarioFeignClient.findByUsername(username);

		if (usuario == null) {
			throw new UsernameNotFoundException(
					"Error en el login: No existe el usuario '" + username + "' en el sistema");
		}

		List<GrantedAuthority> authorities = usuario.getRoles().stream().map(r -> {
			return new SimpleGrantedAuthority(r.getNombre());
		}).collect(Collectors.toList());

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
				authorities);
	}

}
