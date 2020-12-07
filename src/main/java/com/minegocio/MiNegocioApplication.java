package com.minegocio;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MiNegocioApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MiNegocioApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MiNegocioApplication.class, args);
	}

	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
		
}
