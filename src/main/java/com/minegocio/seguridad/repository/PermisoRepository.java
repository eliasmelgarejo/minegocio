package com.minegocio.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.seguridad.domain.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long>{

}
