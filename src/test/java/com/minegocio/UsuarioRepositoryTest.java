package com.minegocio;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.minegocio.seguridad.domain.Usuario;
import com.minegocio.seguridad.repository.UsuarioRepository;

@SpringBootTest
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void whenCreateUsuario_thenCorrect() {

		Usuario u = new Usuario();
		u.setNombreusuario("admin");
		u.setPassword(encoder.encode("admin"));
		u.setNombres("Administrador");
		u.setApellidos("-*-");
		u.setActivo(true);
		u.setBloqueado(false);
		assertThat(repo.save(u)).isNotNull();
		
	}
}
