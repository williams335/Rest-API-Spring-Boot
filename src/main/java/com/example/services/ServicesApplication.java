package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.services.dao.ProduitRepository;
import com.example.services.entities.Produit;

@SpringBootApplication
public class ServicesApplication implements CommandLineRunner {
	
	@Autowired
	private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		produitRepository.save(new Produit("Ordinateur Lx 45",6700,3));
		produitRepository.save(new Produit("Imprimante HP",1700,3));
		produitRepository.save(new Produit("Smart Phone Samsung S9",8000,7));
		
		produitRepository.findAll().forEach(p ->{
			System.out.println(p.toString());
		});
	}

}
