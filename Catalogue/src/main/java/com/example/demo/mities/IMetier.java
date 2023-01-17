package com.example.demo.mities;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
/**
 * 
 * @author moi
 *
 */
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
}
