package com.formation_full_stack.rest_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Utilisateur")
public class Utilisateur {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private long  age;
    private String poste;
    private String competences;
    private String note;
    private String image;

    public Utilisateur(){
        
    }
    public Utilisateur(Long age, String competences, Long id, String image, String nom, String note, String poste) {
        this.age = age;
        this.competences = competences;
        this.id = id;
        this.image = image;
        this.nom = nom;
        this.note = note;
        this.poste = poste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utilisateur{");
        sb.append("id=").append(id);
        sb.append(", nom=").append(nom);
        sb.append(", age=").append(age);
        sb.append(", poste=").append(poste);
        sb.append(", competences=").append(competences);
        sb.append(", note=").append(note);
        sb.append(", image=").append(image);
        sb.append('}');
        return sb.toString();
    }

    
}
