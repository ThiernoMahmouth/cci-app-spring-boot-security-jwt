package com.esp.cci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esp.cci.domain.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>
{

}
