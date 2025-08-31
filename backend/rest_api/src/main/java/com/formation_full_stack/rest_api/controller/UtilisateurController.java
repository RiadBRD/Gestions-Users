package com.formation_full_stack.rest_api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation_full_stack.rest_api.entity.Utilisateur;
import com.formation_full_stack.rest_api.repository.utilisateurRepo;

import jakarta.persistence.EntityNotFoundException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UtilisateurController {

    @Autowired
    private utilisateurRepo utilisateurRepository;

    @GetMapping("/utilisateurs")
    public ResponseEntity<List<Utilisateur>> recupererListe() {
        return ResponseEntity.ok(utilisateurRepository.findAll());
    }

    @GetMapping("/utilisateurs/{id}")
    public ResponseEntity<Utilisateur> recupererId(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur introuvable"));
        return ResponseEntity.ok(utilisateur);
    }

    @PostMapping("/utilisateurs")
    public ResponseEntity<Utilisateur> ajouterUtilisaateur(@RequestBody Utilisateur entity) {
        Utilisateur utilisateur = utilisateurRepository.save(entity);
        return ResponseEntity.ok(utilisateur);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> supprimerUtilisateur(@PathVariable Long id) {

        if (!utilisateurRepository.existsById(id)) {
            throw new EntityNotFoundException("Utilisateur introuvable");
        }
        utilisateurRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Utilisateur> changerUtilisateur(@PathVariable Long id, @RequestBody Utilisateur entity) {
        Utilisateur current = utilisateurRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Utilisateur non disponible"));

        BeanUtils.copyProperties(entity, current,"id");
        utilisateurRepository.save(current);

        return ResponseEntity.ok(current);
    }

    @PutMapping("/add")
    public ResponseEntity<Void> ajouterUtilisateur(@RequestBody Utilisateur entity) {
        utilisateurRepository.save(entity);

        return ResponseEntity.noContent().build();
    }

}