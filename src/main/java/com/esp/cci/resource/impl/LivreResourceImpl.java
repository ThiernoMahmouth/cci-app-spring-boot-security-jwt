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

import com.esp.cci.domain.Livre;
import com.esp.cci.exception.ApplicationException;
import com.esp.cci.exception.RessourceNotFoundException;
import com.esp.cci.resource.Resource;
import com.esp.cci.service.IService;
import com.esp.cci.service.impl.LivreServiceImpl;

@RestController
@RequestMapping("/api/bibliotheque/livres")
public class LivreResourceImpl implements Resource<Livre>
{
	private static Logger log=LoggerFactory.getLogger(LivreServiceImpl.class);
	
	@Autowired
	IService<Livre> livreService;
	
	@Override
	public ResponseEntity<Collection<Livre>> findAll() 
	{
		log.info("Tentative de recuperation de tous les livres");
		return new ResponseEntity<>(livreService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Livre> findById(Long id) 
	{
		Optional<Livre> livreFound=livreService.findById(id);
		if (! livreFound.isPresent())
		{
			throw new RessourceNotFoundException("Le livre avec l'id " + id+ " n'existe pas!");
		}
		return new ResponseEntity<>(livreFound.get(), HttpStatus.OK);
 
	}

	@Override
	public ResponseEntity<Livre> save(Livre livre) 
	{
		if(livre.getId() != null)
		{
			throw new ApplicationException("L'id n'est pas requis pour ajouter un livre!");
		}
		return new ResponseEntity<>(livreService.saveOrUpdate(livre), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Livre> update(Livre livre) 
	{
		if(livre.getId() == null)
		{
			throw new ApplicationException("L'id est requis pour ajouter un livre!");
		}
		return new ResponseEntity<>(livreService.saveOrUpdate(livre), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<String> deleteById(Long id) 
	{
		log.info("Tentative de suppression du livre avec l'id {}", id);
		Optional<Livre> livre = livreService.findById(id);
		if(!livre.isPresent()) {
			throw new RessourceNotFoundException("Le livre avec l'id " + id+ " n'existe pas!");
		}
		return new ResponseEntity<>(livreService.deleteById(id), HttpStatus.OK);
	}

}
