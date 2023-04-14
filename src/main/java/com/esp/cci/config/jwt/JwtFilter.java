package com.esp.cci.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.esp.cci.config.CustomUserDetails;
import com.esp.cci.config.CustomUserDetailsService;


import static org.springframework.util.StringUtils.hasText;

@Component
public class JwtFilter extends GenericFilterBean
{
	private static final String AUTHORIZATION = "Authorization";
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException 
	{
		logger.info("do filter ...");
		String token= getTokenFromRequest((HttpServletRequest) request);
		if (token != null && jwtProvider.validateToken(token)) 
		{
            String userLogin = jwtProvider.getLoginFromToken(token);
            CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userLogin);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
	}
	
	private String getTokenFromRequest(HttpServletRequest request)
	{
		String bearer= request.getHeader(AUTHORIZATION);
		if (hasText(bearer) && bearer.startsWith("bearer "))
		{
			return bearer.substring(7);
		}
		return null;
	}
}
