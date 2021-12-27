package com.minegocio.base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.minegocio.base.domain.MedioPago;
import com.minegocio.base.enums.TipoMedioPago;
import com.minegocio.base.service.MedioPagoService;

@SpringBootTest
public class MedioPagoServiceTest {
	
	
	@Autowired
	private MedioPagoService medioPagoService;
	
	@Test
	public void whenCreateMedioPago_thenCorrect() {
		MedioPago mp = new MedioPago();
		mp.setActivo(true);
		mp.setNombre("Efectivo");
		mp.setDepositable(true);
		mp.setTipoMedioPago(TipoMedioPago.EFECTIVO);
		
		assertNotNull(medioPagoService.create(mp));
	}

	@Test
	public void whenEditMedioPago_thenCorrect() {
				
	    MedioPago mp = medioPagoService.findByNombre("Efectivo").get(0);
	    mp.setNombre("EFECTIVO");
	    
	    MedioPago aux = medioPagoService.update(mp);
	    
	    assertEquals(aux.getNombre(), "EFECTIVO");
	}
	
	@Test
	public void whenMedioPagoDelete_thenCorrect() {
		 MedioPago mp = medioPagoService.findByNombre("EFECTIVO").get(0);
		assertEquals(medioPagoService.delete(mp), true);
	}
}
