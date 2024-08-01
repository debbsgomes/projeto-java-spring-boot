package com.tutorial.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.myfirstproject.entities.Category;

// CategoryRepository // Classe especial que acessa os dados


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
	
	
// Implementação manual dos métodos CRUD														//guardando em memória, não em db
//	private Map<Long, Category> map = new HashMap<>();	//Map: (dictionary em outras linguagens) Coleção de pares chave/valor
//	
//	public void save(Category obj) { //método para salvar categoria
//		map.put(obj.getId(), obj); // Insere cate  goria no map
//	}
//
//	public Category findById(Long id) { //método req id res categoria de id correspondente
//		return map.get(id);
//	}
//	
//	public List<Category> findAll() { // método que retorna todas as categorias
//		return new ArrayList<Category>(map.values()); //pega todos os valores do tipo Category e instancia uma nova lista com esses valores
//	}
}


