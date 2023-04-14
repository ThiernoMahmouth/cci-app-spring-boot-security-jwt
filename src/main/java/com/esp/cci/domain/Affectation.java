package com.esp.cci.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity @Data @AllArgsConstructor
public class Affectation implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	@OneToOne
	private Membre membre;
	@OneToOne
	private Role role;
	private int annee;
}
