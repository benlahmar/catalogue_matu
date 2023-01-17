/**
 * 
 */
package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.mities.IMetier;

/**
 * @author moi
 *
 */
@RestController
public class CatalogueApi {

	@Autowired
	IMetier service;
	
	@PostMapping("/categories")
	public Categorie ajouterc(@RequestBody Categorie c)
	{
		return service.addcat(c);
	}
	
	@GetMapping("/categories")
	public List<Categorie> allc()
	{
		return service.fincatall();
	}
	@GetMapping("/categories/{id}")
	public ResponseEntity<Categorie> findc(@PathVariable(name = "id") long idc)
	{
		Optional<Categorie> c = service.findcat(idc);
		if(c.isPresent())
		{
			return new ResponseEntity<>(c.get(),HttpStatus.FOUND);
		}else
			return new ResponseEntity<Categorie>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/categories/search")
	public ResponseEntity<Categorie> findcat(@RequestParam(name="id") long idc)
	{
		Optional<Categorie> c = service.findcat(idc);
		if(c.isPresent())
		{
			return new ResponseEntity<>(c.get(),HttpStatus.FOUND);
		}else
			return new ResponseEntity<Categorie>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("produits")
	public List<Produit> allp()
	{
		return service.allprd();
	}
	
	
	@PostMapping("produits/add/{idc}")
	public Produit addprd(@RequestBody Produit p,@PathVariable long idc)
	{
		Categorie c = service.findcat(idc).get();
		p.setCat(c);
		p=service.savep(p);
		
		
		return p;
		
	}
	
	 
}
