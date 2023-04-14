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

import com.esp.cci.domain.Exemplaire;
import com.esp.cci.exception.ApplicationException;
import com.esp.cci.exception.RessourceNotFoundException;
import com.esp.cci.service.impl.ExemplaireServiceImpl;

@RestController
@RequestMapping("/api/bibliotheque/exemplaires")
public class ExemplaireResourceImpl 
{
	private static Logger log=LoggerFactory.getLogger(ExemplaireResourceImpl.class);
	@Autowired
	ExemplaireServiceImpl exemplaireService;
	
	public ResponseEntity<Collection<Exemplaire>> findAll(Long idLivre) 
	{
		log.info("Tentative de récupération de la liste des exemplaires");
		return new ResponseEntity<>(exemplaireService.findAll( idLivre), HttpStatus.OK);
	}

	
	public ResponseEntity<Exemplaire> findById(Long idLivre, Long id) 
	{
		log.info("Tentative de récupération de l'exemplaire avec l'id {}", id);
		Optional<Exemplaire> exemplaire= exemplaireService.findById(idLivre,id);
		if (! exemplaire.isPresent())
		{
			throw new RessourceNotFoundException("exemplaire non trouvé!");
		}
		return new ResponseEntity<>(exemplaire.get(), HttpStatus.OK);
	}

	
	public ResponseEntity<Exemplaire> save(Exemplaire exemplaire) 
	{
		log.info("Tentative d'ajout de l'exemplaire {}", exemplaire);
		if(exemplaire.getId() != null)
		{
			throw new ApplicationException("Id n'est pas requis pour ajouter un exemplaire!");
		}
		return new ResponseEntity<>(exemplaireService.saveOrUpdate(exemplaire), HttpStatus.CREATED);
	}

	public ResponseEntity<Exemplaire> update(Exemplaire exemplaire) 
	{
		log.info("Tentative de modification de l'exemplaire {}", exemplaire);
		if(exemplaire.getId() != null)
		{
			throw new ApplicationException("Id est requis pour modifier un exemplaire!");
		}
		return new ResponseEntity<>(exemplaireService.saveOrUpdate(exemplaire), HttpStatus.OK);
	}

	
	public ResponseEntity<String> deleteById(Long idLivre, Long id) 
	{
		log.info("Tentative de suppression de l'exemplaire avec l'id {}", id);
		Optional<Exemplaire> exemplaire = exemplaireService.findById(idLivre, id);
		if(!exemplaire.isPresent()) {
			throw new RessourceNotFoundException("L'exemplaire avec l'id " + id+ " n'existe pas!");
		}
		return new ResponseEntity<>(exemplaireService.deleteById(idLivre, id), HttpStatus.OK);		}
	
}
