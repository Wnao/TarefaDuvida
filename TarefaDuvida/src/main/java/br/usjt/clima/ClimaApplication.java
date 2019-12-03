package br.usjt.clima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClimaApplication {

	// ***********************************************************************
	// *** Importante: Colocar o seu app_id no PrevisaoService
	// ***********************************************************************
	public static void main(String[] args) {
		SpringApplication.run(ClimaApplication.class, args);
	}

}
