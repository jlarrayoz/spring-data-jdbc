package edu.curso.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * La anotación @Table es opcional.
 * Tambien son opcionales los @Column, ya que en nuestro caso el el DDL para la tabla Ingrediente ya utilizamos los mismos nombres
 * para los campos que el de las propiedades de la clase
 * @author juanlarrayoz
 *
 */
@Data
@Table
public class Pizza {
	
	@Id
	private Long id;
	
	@NotNull
	@Size(min=5, max=20, message="El largo mínimo debe ser {min} y el máximo {max}")
	private String nombre;
	
	@NotNull
	@Size(min=2, message="La pizza debe tener al menos 2 ingredientes")
	private List<IngredientePizza> ingredientes;
}
