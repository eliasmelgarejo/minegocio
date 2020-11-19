package com.minegocio;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.minegocio.base.service.PaisService2;

@SpringBootApplication
public class MiNegocioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiNegocioApplication.class, args);
	}

	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	
	//Services
	
	@Bean
	public PaisService2 paisService2() {
		return new PaisService2();
	}
}
