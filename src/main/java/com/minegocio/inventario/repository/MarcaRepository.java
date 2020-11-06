package com.minegocio.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.inventario.domain.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
