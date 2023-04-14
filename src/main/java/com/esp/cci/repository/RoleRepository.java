package com.esp.cci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esp.cci.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> 
{

}
