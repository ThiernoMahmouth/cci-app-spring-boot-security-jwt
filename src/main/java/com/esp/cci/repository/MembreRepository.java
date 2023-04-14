package com.esp.cci.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esp.cci.domain.Membre;

@Repository
public interface MembreRepository extends JpaRepository<Membre, Long>
{
       Optional<Membre> findByLogin(String login);
}
