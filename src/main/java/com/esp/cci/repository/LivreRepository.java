package com.esp.cci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esp.cci.domain.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long>
{

}
