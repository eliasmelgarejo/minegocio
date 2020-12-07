package com.minegocio.seguridad.service;

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

import com.minegocio.seguridad.domain.Rol;
import com.minegocio.seguridad.domain.Usuario;
import com.minegocio.seguridad.repository.RolRepository;
import com.minegocio.seguridad.repository.UsuarioRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private RolRepository repo_rol;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = repo.findByNombreusuario(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
//		for (Rol rol : repo_rol.findByNombreUsuario(u.getNombreusuario())) {
//			roles.add(new SimpleGrantedAuthority(rol.getNombre()));			
//		}
		
		roles.add(new SimpleGrantedAuthority("ADMIN"));	
		
		UserDetails userDetails = new User(u.getNombreusuario(),u.getPassword(),roles);
		return userDetails;
	}

}
