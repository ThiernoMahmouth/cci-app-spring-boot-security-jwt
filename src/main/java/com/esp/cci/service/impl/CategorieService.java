package com.esp.cci.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esp.cci.domain.Categorie;
import com.esp.cci.repository.CategorieRepository;
import com.esp.cci.service.IService;

@Service
public class CategorieService implements IService<Categorie>
{
	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public Collection<Categorie> findAll() 
	{
		return categorieRepository.findAll();
	}

	@Override
	public Optional<Categorie> findById(Long id) 
	{
		return categorieRepository.findById(id);
	}

	@Override
	public Categorie saveOrUpdate(Categorie t) 
	{
		return categorieRepository.saveAndFlush(t);
	}

	@Override
	public String deleteById(Long id) 
	{
		HashMap<String, String> result = new HashMap<>();
		categorieRepository.deleteById(id);
		result.put("message", "Categorie supprimee avec succes!");
		return result.toString();
	}

}
