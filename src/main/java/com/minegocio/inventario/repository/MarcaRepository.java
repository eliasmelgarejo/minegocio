package com.minegocio.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.inventario.domain.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
