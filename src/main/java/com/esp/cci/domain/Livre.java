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
public class Livre implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	private String titre;
	private Long isbn;
	private String auteur;
	private String langue;
	@OneToOne
	private Categorie categorie;
	private String description;
	private String photo;
	private int nb_exemplaires;
}
