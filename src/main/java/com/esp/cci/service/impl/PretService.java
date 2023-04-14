package com.esp.cci.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.esp.cci.domain.Pret;
import com.esp.cci.repository.PretRepository;
import com.esp.cci.service.IService;

public class PretService implements IService<Pret>
{
	@Autowired
	PretRepository pretRepository;
	
	@Override
	public Collection<Pret> findAll() 
	{
		return pretRepository.findAll();
	}

	@Override
	public Optional<Pret> findById(Long id) 
	{
		return pretRepository.findById(id);
	}

	@Override
	public Pret saveOrUpdate(Pret pret) 
	{
		return pretRepository.saveAndFlush(pret);
	}

	@Override
	public String deleteById(Long id) 
	{
		HashMap<String, String> result = new HashMap<>();
		pretRepository.deleteById(id);
		result.put("message", "Pret supprime avec succes!");
		return result.toString();
	}

}
