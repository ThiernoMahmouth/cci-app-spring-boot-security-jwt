package com.esp.cci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esp.cci.domain.Lecteur;

@Repository
public interface LecteurRepository extends JpaRepository<Lecteur, Long>
{

}
