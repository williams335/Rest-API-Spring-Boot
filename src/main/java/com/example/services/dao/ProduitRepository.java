package com.example.services.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.services.entities.Produit;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
