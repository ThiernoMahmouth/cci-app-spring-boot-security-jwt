package com.esp.cci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esp.cci.domain.Pret;

@Repository
public interface PretRepository extends JpaRepository<Pret, Long>
{

}
