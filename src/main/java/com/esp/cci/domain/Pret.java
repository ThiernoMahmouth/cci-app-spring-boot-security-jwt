package com.esp.cci.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity @Data @AllArgsConstructor
public class Pret implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id 
	private Long id;
	private LocalDate date;
	private LocalDate date_retour;
	private boolean renouvele;
	
	
}
