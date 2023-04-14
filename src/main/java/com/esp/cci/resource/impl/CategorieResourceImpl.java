package com.esp.cci.resource.impl;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esp.cci.domain.Categorie;
import com.esp.cci.exception.ApplicationException;
import com.esp.cci.exception.RessourceNotFoundException;
import com.esp.cci.resource.Resource;
import com.esp.cci.service.IService;

@RestController
@RequestMapping("/api/bibliotheque/categories")
public class CategorieResourceImpl implements Resource<Categorie>
{
	private static Logger log=LoggerFactory.getLogger(CategorieResourceImpl.class);
	@Autowired
	IService<Categorie> categorieService;
	
	@Override
	public ResponseEntity<Collection<Categorie>> findAll() 
	{
		log.info("Tentative de récupération de la liste des categories");
		return new ResponseEntity<>(categorieService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Categorie> findById(Long id) 
	{
		log.info("Tentative de récupération de l'exemplaire avec l'id {}", id);
		Optional<Categorie> categorie= categorieService.findById(id);
		if (! categorie.isPresent())
		{
			throw new RessourceNotFoundException("La categorie avec l'id " + id+ " n'existe pas!");
		}
		return new ResponseEntity<>(categorie.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Categorie> save(Categorie categorie) 
	{
		log.info("Tentative d'ajout de la categorie {}", categorie);
		if(categorie.getId() != null)
		{
			throw new ApplicationException("Id n'est pas requis pour ajouter une categorie!");
		}
		return new ResponseEntity<>(categorieService.saveOrUpdate(categorie), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Categorie> update(Categorie categorie) 
	{
		log.info("Tentative de modification de la categorie {}", categorie);
		if(categorie.getId() != null)
		{
			throw new ApplicationException("Id est requis pour modifier une categorie!");
		}
		return new ResponseEntity<>(categorieService.saveOrUpdate(categorie), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) 
	{
		log.info("Tentative de suppression de la categorie avec l'id {}", id);
		Optional<Categorie> categorie = categorieService.findById(id);
		if(!categorie.isPresent()) {
			throw new RessourceNotFoundException("La categorie avec l'id " + id+ " n'existe pas!");
		}
		return new ResponseEntity<>(categorieService.deleteById(id), HttpStatus.OK);	
	}
	
}
