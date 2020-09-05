package com.example.services.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.dao.ProduitRepository;
import com.example.services.entities.Produit;

@CrossOrigin(origins = "*")
@RestController
public class ProduitController {
	
	private final ProduitRepository repository;

	ProduitController(ProduitRepository repository) {
	    this.repository = repository;
	  }

	  // Aggregate root

	  @GetMapping("/ListProduits")
	  List<Produit> all() {
	    return repository.findAll();
	  }

	  @PostMapping("/ListProduits")
	  Produit newProduit(@RequestBody Produit newProduit) {
	    return repository.save(newProduit);
	  }

	  // Single item

	  @GetMapping("/ListProduits/{id}")
	  Optional<Produit> one(@PathVariable Long id) {

	    return repository.findById(id);
	  }

	  @PutMapping("/ListProduits/{id}")
	  Produit replaceProduit(@RequestBody Produit newProduit, @PathVariable Long id) {

	    return repository.findById(id)
	      .map(produit -> {
	    	produit.setDesignation(newProduit.getDesignation());
	        produit.setPrice(newProduit.getPrice());
	        produit.setQuantite(newProduit.getQuantite());
	        return repository.save(produit);
	      })
	      .orElseGet(() -> {
	    	  newProduit.setId(id);
	        return repository.save(newProduit);
	      });
	  }

	  @DeleteMapping("/ListProduits/{id}")
	  void deleteProduit(@PathVariable Long id) {
	    repository.deleteById(id);
	  }

}
