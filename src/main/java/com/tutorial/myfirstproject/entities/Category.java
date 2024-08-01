package com.tutorial.myfirstproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //chave primaria do banco de dados
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@JsonIgnore // acaba com serialização de lista de categorias(evitando json gigante)
	//relacionando diferentes objetos (Categorias e Produtos) // instanciando lista de produtos
	@OneToMany(mappedBy = "category") // argumento é o nome do atributo
	private List<Product> products = new ArrayList<>();
	
	public Category() {
	
	}  

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	//acessa lista de produtos
	public List<Product> getProducts() {
		return products;
	}


	//linhas abaixo criam critério personalizado de comparação
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
	//linhas acima criam critério personalizado de comparação
	
	 
}
