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

import com.esp.cci.domain.Lecteur;
import com.esp.cci.exception.ApplicationException;
import com.esp.cci.exception.RessourceNotFoundException;
import com.esp.cci.resource.Resource;
import com.esp.cci.service.IService;

@RestController
@RequestMapping("/api/bibliotheque/lecteurs")
public class LecteurResourceImpl implements Resource<Lecteur>
{
	private static Logger log=LoggerFactory.getLogger(LecteurResourceImpl.class);
	@Autowired
	IService<Lecteur> lecteurService;
	@Override
	public ResponseEntity<Collection<Lecteur>> findAll() 
	{
		log.info("Tentative de récupération de la liste des lecteurs");
		return new ResponseEntity<>(lecteurService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Lecteur> findById(Long id) 
	{
		log.info("Tentative de récupération du lecteur avec l'id {}", id);
		Optional<Lecteur> lecteur= lecteurService.findById(id);
		if (! lecteur.isPresent())
		{
			throw new RessourceNotFoundException("Le lecteur avec l'id " + id+ " n'existe pas!");
		}
		return new ResponseEntity<>(lecteur.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Lecteur> save(Lecteur lecteur) 
	{
		log.info("Tentative d'ajout du lecteur {}", lecteur);
		if(lecteur.getId() != null)
		{
			throw new ApplicationException("Id n'est pas requis pour ajouter un lecteur!");
		}
		return new ResponseEntity<>(lecteurService.saveOrUpdate(lecteur), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Lecteur> update(Lecteur lecteur) 
	{
		log.info("Tentative de modification du lecteur {}", lecteur);
		if(lecteur.getId() != null)
		{
			throw new ApplicationException("Id est requis pour modifier un lecteur!");
		}
		return new ResponseEntity<>(lecteurService.saveOrUpdate(lecteur), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) 
	{
		log.info("Tentative de suppression du lecteur avec l'id {}", id);
		Optional<Lecteur> lecteur = lecteurService.findById(id);
		if(!lecteur.isPresent()) {
			throw new RessourceNotFoundException("Le lecteur avec l'id " + id+ " n'existe pas!");
		}
		return new ResponseEntity<>(lecteurService.deleteById(id), HttpStatus.OK);	}
	
}
