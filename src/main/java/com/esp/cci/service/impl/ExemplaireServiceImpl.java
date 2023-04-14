package com.esp.cci.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esp.cci.domain.Exemplaire;
import com.esp.cci.repository.ExemplaireRepository;

@Service
public class ExemplaireServiceImpl {
	@Autowired
	ExemplaireRepository exemplaireRepository;
	
	
	public Collection<Exemplaire> findAll(Long idLivre) 
	{
		return exemplaireRepository.findByLivre(idLivre);
	}

	public Optional<Exemplaire> findById(Long idLivre, Long idExemplaire) 
	{
		return exemplaireRepository.findByLivreAndId(idLivre, idExemplaire);
	}

	@Transactional
	public Exemplaire saveOrUpdate(Exemplaire exemplaire) 
	{
		return exemplaireRepository.saveAndFlush(exemplaire);
	}
	
	public String deleteById(Long idLivre, Long id) 
	{
		HashMap<String, String> result = new HashMap<>();
		exemplaireRepository.deleteByLivreAndId(idLivre, id);
		result.put("message", "Exemplaire supprimee avec succes!");
		return result.toString();
	}

	
}
