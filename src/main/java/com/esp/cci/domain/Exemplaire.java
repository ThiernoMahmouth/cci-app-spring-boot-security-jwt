package com.esp.cci.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Exemplaire implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	@OneToOne
	private Livre livre;
	private String etat;
	private int prix;
	private String donateur;
}
