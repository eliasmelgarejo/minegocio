package com.minegocio.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.inventario.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	Producto findByDescripcioncorta(String descripcioncorta);
}
