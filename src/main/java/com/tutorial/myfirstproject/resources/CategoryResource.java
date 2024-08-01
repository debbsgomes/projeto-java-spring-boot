
package com.tutorial.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//ctrl + shift + O

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.myfirstproject.entities.Category;
import com.tutorial.myfirstproject.repositories.CategoryRepository;

@RestController //REST - springboot reconhece classe enquanto recurso rest
@RequestMapping(value = "/categories") // rota raiz depois de localhost
public class CategoryResource {

	// é preciso instanciar a classe CategoryRepository dentro de Category Resource
	//Injeção de dependencias do spring boot. Nesse caso, através de framewrok.
	@Autowired //dep que faz a instanciação + (ctrl shit O)
	private CategoryRepository categoryRepository;
	
	@GetMapping //responde req GET da API REST na rota raiz
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryRepository.findAll();
		/* Antes de pegar os métodos do category resource:
		List<Category> list = new ArrayList <>();
		list.add(new Category(1L, "Eletronics"));
		list.add(new Category(2L, "Books"));*/
		return ResponseEntity.ok().body(list); //.ok = status(200*)
	}

	@GetMapping(value = "/{id}") // adicionando id na rota principal
	public ResponseEntity<Category> findById(@PathVariable Long id) { //path.. reconhece a id escrita na rota
		Category cat = categoryRepository.findById(id).get(); //.get obtem objeto dentro do optional
				      //new Category(1L, "Eletronics"); antes de instanciar
		return ResponseEntity.ok().body(cat);
	}
	
}
