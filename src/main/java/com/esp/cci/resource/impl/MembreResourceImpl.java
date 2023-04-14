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

import com.esp.cci.domain.Membre;
import com.esp.cci.exception.RessourceNotFoundException;
import com.esp.cci.resource.Resource;
import com.esp.cci.service.IService;
import com.esp.cci.service.impl.LivreServiceImpl;

@RestController
@RequestMapping("/api/membres")
public class MembreResourceImpl implements Resource<Membre>
{
	private static Logger log=LoggerFactory.getLogger(LivreServiceImpl.class);
	
	@Autowired
	IService<Membre> membreService;
	
	@Override
	public ResponseEntity<Collection<Membre>> findAll() 
	{
		log.info("");
		return new ResponseEntity<>(membreService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Membre> findById(Long id) 
	{
		Optional<Membre> membre=membreService.findById(id);
		if (! membre.isPresent())
		{
			throw new RessourceNotFoundException("Le membre avec l'id " + id+ " n'existe pas!");
		}
		return new ResponseEntity<>(membre.get(), HttpStatus.OK);
 
	}

	@Override
	public ResponseEntity<Membre> save(Membre membre) 
	{
		if(membre.getId() != null)
		{
			throw new RessourceNotFoundException("id ...");
		}
		return new ResponseEntity<>(membreService.saveOrUpdate(membre), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Membre> update(Membre membre) 
	{
		if(membre.getId() == null)
		{
			throw new RessourceNotFoundException("id ...");
		}
		return new ResponseEntity<>(membreService.saveOrUpdate(membre), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) 
	{
		log.info("Tentative de suppression du membre avec l'id {}", id);
		Optional<Membre> membre = membreService.findById(id);
		if(!membre.isPresent()) {
			throw new RessourceNotFoundException("Le membre avec l'id " + id+" n'existe pas!");
		}
		return new ResponseEntity<>(membreService.deleteById(id), HttpStatus.OK);
	}

	
}
