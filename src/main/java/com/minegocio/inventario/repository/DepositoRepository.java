package com.minegocio.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.inventario.domain.Deposito;

@Repository
public interface DepositoRepository extends JpaRepository<Deposito, Long>{
	Deposito findByNombre(String nombre);
}
