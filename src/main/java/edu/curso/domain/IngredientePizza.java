package edu.curso.domain;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table
public class IngredientePizza {
	
	private final String ingrediente;
}
