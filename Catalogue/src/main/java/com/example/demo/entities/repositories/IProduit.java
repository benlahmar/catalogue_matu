package com.example.demo.entities.repositories;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Produit;
import com.example.demo.entities.ProduitDto;

public interface IProduit extends JpaRepository<Produit,Long>{

	List<Produit> findByQuantityLessThan(int seuil);
	List<Produit> findByCatId(long id);
	
	@Query("select p.id as id, p.desg as desg from Produit p where p.desg=:dsg")
	List<ProduitDto> findDesg(@Param("dsg") String dsg);
	
	@Query("select p.id as id, p.desg as desg, p.price as price from Produit p where p.desg=:dsg")
	public List<Tuple>  findbyx(@Param("dsg") String dsg);
	
	
}
