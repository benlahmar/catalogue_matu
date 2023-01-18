package com.example.demo.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Categorie;

@RepositoryRestResource()
public interface IRestCategorie extends JpaRepository<Categorie, Long>{

	
	
}
