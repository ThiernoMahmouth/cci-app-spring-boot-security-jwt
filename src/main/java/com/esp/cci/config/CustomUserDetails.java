package com.esp.cci.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.esp.cci.domain.Membre;

public class CustomUserDetails implements UserDetails
{
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;
	private Collection<? extends GrantedAuthority> grantedAuthorities;
	
	public static CustomUserDetails fromUserToCustomUserDetails(Membre membre)
	{
		CustomUserDetails c=new CustomUserDetails();
		c.login=membre.getLogin();
		c.password = membre.getPassword();
		c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(membre.getRole().getName()));
		return c;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return grantedAuthorities;
	}

	@Override
	public String getPassword() 
	{
		return password;
	}

	@Override
	public String getUsername() 
	{
		return login;
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		return false;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		return false;
	}

	@Override
	public boolean isEnabled() 
	{
		return false;
	}

}
