/**
 * 
 */
package com.example.demo.api;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.persistence.Tuple;

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
import com.example.demo.entities.ProduitDto;
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
	@GetMapping("produits/{id}")
	public ResponseEntity<Produit> getprd(@PathVariable long id) 
	{
		Optional<Produit> po = service.getidprd(id);
		if(po.isPresent())
		{
			return new ResponseEntity<>(po.get(),HttpStatus.OK);
		}else
			return new ResponseEntity<Produit>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("produits/search/{dsg}")
	public List<ProduitDto> allpr(@PathVariable String dsg)
	{
		return service.getdsg(dsg);
	}
	
	@GetMapping("produits/search2/{dsg}")
	public List<Tuple> allpr2(@PathVariable String dsg)
	{
		List<Tuple> res = service.findbyx(dsg);
		res.forEach(x-> System.out.println(x.get(0)));
		
		
		return res;
	}
	 
	@GetMapping("/produits/kk")
	public List<Produit> getdataprd()
	{
		return service.findByCondition(x->x.getPrice()>20);
	}
	
	
	@GetMapping("/produits/qte")
	public List<Produit> getdatdprd2()
	{
		List<Produit> res = service.findByCondition(x->x.getQuantity()<10);
		
		
		return res;
	}
	
	@GetMapping("/produits/complex")
	public List<Produit> getdatdprd3()
	{
		Predicate<Produit> prd1= x-> x.getQuantity()<20;
		Predicate<Produit> prd2= x-> x.getPrice()>120;
		Predicate<Produit> prd3= x-> x.getDesg().startsWith("cl");
		
		return service.findByCondition(prd1.and(prd2).or(prd3));
	}
}
