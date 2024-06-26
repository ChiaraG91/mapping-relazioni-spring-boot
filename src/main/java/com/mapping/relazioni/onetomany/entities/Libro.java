package com.mapping.relazioni.onetomany.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Libro {

    @Id
    private Long id;
    private String titolo;

    @JsonIgnore
    @OneToMany(mappedBy = "libro")
    private List<Autore> autori;

    public Libro(Long id, String titolo, List<Autore> autori) {
        this.id = id;
        this.titolo = titolo;
        this.autori = autori;
    }

    public Libro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Autore> getAutori() {
        return autori;
    }

    public void setAutori(List<Autore> autori) {
        this.autori = autori;
    }
}
