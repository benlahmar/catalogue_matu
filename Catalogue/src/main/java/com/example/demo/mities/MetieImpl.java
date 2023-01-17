package com.example.demo.mities;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.entities.repositories.ICategorie;
import com.example.demo.entities.repositories.IProduit;

@Service
public class MetieImpl implements IMetier{
	@Autowired
	ICategorie crepo;
	@Autowired
	IProduit prepo;
	
	@Override
	public Categorie addcat(Categorie c) {	
		
		return crepo.save(c);
	}

	@Override
	public List<Categorie> fincatall() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	@Override
	public List<Produit> getprd(int qte) {
		// TODO Auto-generated method stub
		return prepo.findByQuantityLessThan(qte);
	}

	@Override
	public Produit savep(Produit p) {
		
		return prepo.save(p);
	}

	@Override
	public List<Produit> getbycat(int idcat) {
		// TODO Auto-generated method stub
		return prepo.findByCatId(idcat);
	}

	@Override
	public Optional<Categorie> findcat(long id) {
		
		return crepo.findById(id);
	}

	@Override
	public List<Produit> allprd() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

}
