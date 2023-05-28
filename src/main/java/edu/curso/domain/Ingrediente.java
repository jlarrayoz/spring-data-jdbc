package edu.curso.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Data
@AllArgsConstructor 
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Table
public class Ingrediente implements Persistable<String>{
	
	@Id
	private String id;
	
	private String nombre;
	
	private TipoIngrediente tipo;

	@Override
	public boolean isNew() {
		return id != null && !id.isEmpty() ? true : false;
	}
}
