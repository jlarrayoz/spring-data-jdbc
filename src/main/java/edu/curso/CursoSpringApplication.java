package edu.curso;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.curso.domain.Ingrediente;
import edu.curso.domain.TipoIngrediente;
import edu.curso.models.IngredienteRepository;

@SpringBootApplication
public class CursoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}
	
	
	/**
	 * Metodo responsable de dejar disponible en el contexto de spring la un bean de CommandLineRunner.
	 * CommandLineRunner nos permite ejecutar lógica en el startup de la aplicación 
	 * @param repo Repository de Ingredientes para persistir los ingredientes
	 * @return
	 */
	@Bean
	CommandLineRunner dataLoader(IngredienteRepository repo) {
		return (args -> {
			
			//MASAS
			repo.save(new Ingrediente("MC", "Masa común", TipoIngrediente.MASA));
			repo.save(new Ingrediente("MM", "Masa madre", TipoIngrediente.MASA));
			repo.save(new Ingrediente("MIT", "Masa italiana", TipoIngrediente.MASA));
			
			//QUESOS
			repo.save(new Ingrediente("QM", "Queso muzzarella", TipoIngrediente.QUESO));
			repo.save(new Ingrediente("QD", "Queso dambo", TipoIngrediente.QUESO));
			repo.save(new Ingrediente("QP", "Queso persistente", TipoIngrediente.QUESO));
			repo.save(new Ingrediente("QC", "Queso commandLineRunner", TipoIngrediente.QUESO));
		});
	}
}
