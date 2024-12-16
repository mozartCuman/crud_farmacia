package com.crud_farmacia.crud_farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.crud_farmacia.crud_farmacia.model.Categorias;
import com.crud_farmacia.crud_farmacia.repository.CategoriasRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriasController {
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categorias>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(categoriasRepository.findAllByNameContainingIgnoreCase(nome));
	}
	
	@GetMapping
	public ResponseEntity<List<Categorias>> getAll(){
		return ResponseEntity.ok(categoriasRepository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Categorias> getById(@PathVariable Long id) {
		return categoriasRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Categorias> post(@Valid @RequestBody Categorias treino) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriasRepository.save(treino));
	}
	
	@PutMapping
	public ResponseEntity<Categorias> put(@Valid @RequestBody Categorias categorias) {
		return categoriasRepository.findById(categorias.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(categoriasRepository.save(categorias)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Categorias> categorias = categoriasRepository.findById(id);

		if (categorias.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		categoriasRepository.deleteById(id);
	}

	
}
