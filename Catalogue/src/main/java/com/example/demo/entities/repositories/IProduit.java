package com.example.demo.entities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Produit;

public interface IProduit extends JpaRepository<Produit,Long>{

	List<Produit> findByQuantityLessThan(int seuil);
	List<Produit> findByCatId(long id);
}
