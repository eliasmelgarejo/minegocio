package com.minegocio.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.seguridad.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
