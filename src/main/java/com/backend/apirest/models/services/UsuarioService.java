package com.backend.apirest.models.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.apirest.models.dao.IUsuarioDao;
import com.backend.apirest.models.entity.usuario;

@Service
public class UsuarioService implements IUsuarioService,UserDetailsService {
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		usuario usuario = usuarioDao.buscarUsuario(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '" + username +"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = null;
		
		if(usuario != null) {
			authorities = new ArrayList<>();

			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		}
		
		return new User(usuario.getUsername(), usuario.getPasswd(), true, true, true, true, authorities);
	}

	@Override
	public usuario buscarUsuario(String usuario) {
		return usuarioDao.buscarUsuario(usuario);
	}

}
