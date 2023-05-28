package edu.curso.models;

import org.springframework.data.repository.CrudRepository;

import edu.curso.domain.OrdenPizza;

public interface OrdenPizzaRepository extends CrudRepository<OrdenPizza, Long>{
	
	//Metodo encargado de guardar a la BD una orden de pizza (Con sus respectivas pizzas)
	OrdenPizza save(OrdenPizza orden);

}
