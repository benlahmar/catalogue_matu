package com.example.demo.mities;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.persistence.Tuple;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
/**
 * 
 * @author moi
 *
 */
import com.example.demo.entities.ProduitDto;
public interface IMetier {
	/**
	 * pour ajouter une categorie
	 * @param c
	 * @return
	 */
	public Categorie addcat(Categorie c);
	/**
	 * Recuperer la liste des categorie
	 * @return
	 */
	public List<Categorie> fincatall();
	/**
	 * pour recuperer la liste des produits dont la quantite est > a un seuil
	 * @param qte
	 * @return
	 */
	public List<Produit> getprd(int qte);
	public Produit savep(Produit p);
	/**
	 * Recuperer les produits d'un categorie dont le d est passé par param
	 * @param idcat
	 * @return
	 */
	public List<Produit> getbycat(int idcat);
	
	public List<Produit> allprd();
	public Optional<Categorie> findcat(long id);
	
	public List<ProduitDto> getdsg( String dsg);
	
	public List<Tuple>  findbyx(String d);
	
	public List<Produit> findByCondition(Predicate<Produit> prid);
	
}
