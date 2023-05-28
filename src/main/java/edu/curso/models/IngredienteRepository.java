package edu.curso.models;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import edu.curso.domain.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, String>{

	//Metodo encargado de devolver todos los elementos del modelo
	List<Ingrediente> findAll();

	//Metodo encargado de buscar un elemento por el id
	Optional<Ingrediente> findById(String id);

	//Metodo encargado de agregar un ingrediente al modelo
	Ingrediente save(Ingrediente ingrediente);

}
