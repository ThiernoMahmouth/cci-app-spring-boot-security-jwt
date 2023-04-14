package com.esp.cci.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esp.cci.domain.Lecteur;
import com.esp.cci.repository.LecteurRepository;
import com.esp.cci.service.IService;

@Service
public class LecteurService implements IService<Lecteur>
{
	@Autowired
	LecteurRepository lecteurRepository;
	@Override
	public Collection<Lecteur> findAll() {
		return lecteurRepository.findAll();
	}

	@Override
	public Optional<Lecteur> findById(Long id) {
		return lecteurRepository.findById(id);
	}

	@Override
	public Lecteur saveOrUpdate(Lecteur lecteur) {
		return lecteurRepository.saveAndFlush(lecteur);
	}

	@Override
	public String deleteById(Long id) 
	{
		HashMap<String, String> result = new HashMap<>();
		lecteurRepository.deleteById(id);
		result.put("message", "Lecteur supprime avec succes!");
		return result.toString();	
	}

}
