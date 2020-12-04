package com.minegocio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minegocio.seguridad.domain.Usuario;
import com.minegocio.seguridad.repository.UsuarioRepository;

@SpringBootTest
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repo;
	@Test
	public void whenCreateUsuario_thenCorrect() {
		Usuario u = new Usuario();
		u.setNombreusuario("emelgarejo");
		u.setPassword("123");
		u.setNombres("Elias Jan");
		u.setApellidos("Melgarejo Herrera");
		u.setActivo(true);
		u.setBloqueado(false);
		Usuario retorno = repo.save(u);
		assertThat(retorno).isNotNull();
		
	}
}
