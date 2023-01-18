package com.example.demo.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entities.Categorie;

public interface ICategorie extends JpaRepository<Categorie, Long>{

	@Override
	@RestResource(exported = false)
	void deleteById(Long id) ;
	@RestResource(path = "lib", rel = "lib1")
	List<Categorie> findByLibelle(String li);
}
