/*package com.minegocio.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.InfoNegocio;

@Repository
public interface InfoNegocioRepository extends JpaRepository<InfoNegocio, Long>{
	InfoNegocio findByNombre(String nombre);
}
*/


/*
 * package com.minegocio.base.repository;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.minegocio.base.domain.InfoNegocio;
 * 
 * @Repository public interface InfoNegocioRepository extends
 * JpaRepository<InfoNegocio, Long>{ InfoNegocio findByNombre(String nombre); }
 */




package com.minegocio.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minegocio.base.domain.InfoNegocio;

@Repository
public interface InfoNegocioRepository extends JpaRepository<InfoNegocio, Long>{
	InfoNegocio findByNombre(String nombre);
}


