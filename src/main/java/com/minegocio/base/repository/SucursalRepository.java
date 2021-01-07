package com.minegocio.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long>{

}




