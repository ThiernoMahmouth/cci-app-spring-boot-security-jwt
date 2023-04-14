package com.esp.cci.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.esp.cci.domain.Membre;
import com.esp.cci.service.impl.MembreServiceImpl;

@Component
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private MembreServiceImpl membreService;

	@Override
	public CustomUserDetails loadUserByUsername(String login) throws UsernameNotFoundException 
	{
		Optional<Membre> membre = membreService.findByLogin(login);
		if (! membre.isPresent())
		{
			return null;
		}
		return CustomUserDetails.fromUserToCustomUserDetails(membre.get());
	} 	

}
