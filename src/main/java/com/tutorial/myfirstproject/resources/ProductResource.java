
package com.tutorial.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//ctrl + shift + O

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.myfirstproject.entities.Product;
import com.tutorial.myfirstproject.repositories.ProductRepository;

@RestController //REST - springboot reconhece classe enquanto recurso rest
@RequestMapping(value = "/products") // rota raiz depois de localhost
public class ProductResource {

	// é preciso instanciar a classe ProductRepository dentro de Product Resource
	//Injeção de dependencias do spring boot. Nesse caso, através de framewrok.
	@Autowired //dep que faz a instanciação + (ctrl shit O)
	private ProductRepository categoryRepository;
	
	@GetMapping //responde req GET da API REST na rota raiz
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = categoryRepository.findAll();
		/* Antes de pegar os métodos do category resource:
		List<Product> list = new ArrayList <>();
		list.add(new Product(1L, "Eletronics"));
		list.add(new Product(2L, "Books"));*/
		return ResponseEntity.ok().body(list); //.ok = status(200*)
	}

	@GetMapping(value = "/{id}") // adicionando id na rota principal
	public ResponseEntity<Product> findById(@PathVariable Long id) { //path.. reconhece a id escrita na rota
		Product cat = categoryRepository.findById(id).get();
				      //new Product(1L, "Eletronics"); antes de instanciar
		return ResponseEntity.ok().body(cat);
	}
	
}
