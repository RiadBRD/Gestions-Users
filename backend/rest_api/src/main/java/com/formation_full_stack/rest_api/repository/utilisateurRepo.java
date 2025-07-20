package com.formation_full_stack.rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation_full_stack.rest_api.entity.Utilisateur;


@Repository
public interface utilisateurRepo extends JpaRepository<Utilisateur,Long >  {
    
}
