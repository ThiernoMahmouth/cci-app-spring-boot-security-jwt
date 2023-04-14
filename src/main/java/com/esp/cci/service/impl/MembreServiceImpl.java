package com.esp.cci.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esp.cci.domain.Membre;
import com.esp.cci.repository.MembreRepository;
import com.esp.cci.service.IService;


@Service
public class MembreServiceImpl implements IService<Membre>
{
	@Autowired
	MembreRepository membreRepository;
	@Override
	public Collection<Membre> findAll() 
	{
		return membreRepository.findAll();
	}

	@Override
	public Optional<Membre> findById(Long id) 
	{
		return membreRepository.findById(id);
	}

	@Override
	@Transactional
	public Membre saveOrUpdate(Membre membre) 
	{
		return membreRepository.saveAndFlush(membre);
	}
	
	 public Optional<Membre> findByLogin(String login)
	 {
		 return membreRepository.findByLogin(login);
	 }
	 
	@Override
	public String deleteById(Long id) 
	{
		 HashMap<String, String> result = new HashMap<>();
		 membreRepository.deleteById(id);
		 result.put("message", "Categorie supprimee avec succes!");
		 return result.toString();
	}

}
