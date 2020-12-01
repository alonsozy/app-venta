package com.app.store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.store.entity.UserSecurity;

@Service
public class UsuarioService /*implements UserDetailsService*/ {

//	private Logger log = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	IUserService userService;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("Obteniendo la informacion del usuario");
//		UserSecurity usuario = userService.findUser(username);
//
//		if (usuario == null) {
//			log.error("Error en el login, no existe el usuario '" + username + "'");
//			throw new UsernameNotFoundException("Error en el login, no existe el usuario '" + username + "'");
//		}
//		List<GrantedAuthority> authorities = usuario.getRoles().stream().map(role -> new SimpleGrantedAuthority(role))
//				.collect(Collectors.toList());
//
//		log.info("Usuario autenticado: " + username);
//		log.debug("Logueo exitoso");
//		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isStatus(), true, true, true,
//				authorities);
//	}

}
