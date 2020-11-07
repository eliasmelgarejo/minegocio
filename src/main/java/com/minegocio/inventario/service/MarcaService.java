package com.minegocio.inventario.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.minegocio.core.IOperations;
import com.minegocio.inventario.domain.Marca;

@Service
@Transactional
public interface MarcaService extends IOperations<Marca> {

}
