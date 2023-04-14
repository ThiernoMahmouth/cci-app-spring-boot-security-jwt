package com.esp.cci.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esp.cci.domain.Exemplaire;

@Repository
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long>
{
	Optional<Exemplaire> findByLivreAndId(Long idLivre, Long id);
	Collection<Exemplaire> findByLivre(Long idLivre);
	void deleteByLivreAndId(Long idLivre, Long id);
}
