package com.minegocio.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minegocio.seguridad.domain.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
	@Query(value = "SELECT r.* FROM rol r INNER JOIN usuario_roles s ON r.id=s.roles_id AND s.usuarios_nombreusuario=: PARAM", nativeQuery = true)
	List<Rol> findByNombreUsuario(@Param("PARAM") String PARAM);
}
