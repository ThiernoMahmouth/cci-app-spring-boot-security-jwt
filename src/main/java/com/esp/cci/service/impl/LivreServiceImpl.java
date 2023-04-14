package com.esp.cci.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esp.cci.domain.Livre;
import com.esp.cci.repository.LivreRepository;
import com.esp.cci.service.IService;

@Service
public class LivreServiceImpl implements IService<Livre>
{
	@Autowired
	LivreRepository livreRepository;
	@Override
	public Collection<Livre> findAll() 
	{
		return livreRepository.findAll();
	}

	@Override
	public Optional<Livre> findById(Long id) 
	{
		return livreRepository.findById(id);
	}

	@Override
	@Transactional
	public Livre saveOrUpdate(Livre t) 
	{
		return livreRepository.saveAndFlush(t);
	}

	@Override
	public String deleteById(Long id) 
	{
			HashMap<String, String> result = new HashMap<>();
			livreRepository.deleteById(id);
			result.put("message", "Livre supprimee avec succes!");
			return result.toString();
	}

}
