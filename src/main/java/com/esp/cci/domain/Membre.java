package com.esp.cci.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data 
@AllArgsConstructor @NoArgsConstructor
public class Membre implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private Genre genre;
	private String email;
	private String telephone;
	private Statut statut;
	private String ecole;
	private String departement;
	private int annee_adhesion;
	@Null
	private int annee_sortie;
	private String login;
	private String password;
	@ManyToOne
	private Role role;
}
