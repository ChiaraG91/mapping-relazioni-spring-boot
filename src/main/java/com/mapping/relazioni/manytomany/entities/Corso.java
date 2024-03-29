package com.mapping.relazioni.manytomany.entities;

import com.mapping.relazioni.onetoone.entities.Studente;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Corso {

    @Id
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "corsi")
    private List<Student> studenti;

    public Corso(Long id, String nome, List<Student> studenti) {
        this.id = id;
        this.nome = nome;
        this.studenti = studenti;
    }

    public Corso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }
}
