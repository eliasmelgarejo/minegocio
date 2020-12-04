package com.minegocio.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.seguridad.domain.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

}
