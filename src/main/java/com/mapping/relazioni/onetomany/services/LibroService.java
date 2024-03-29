package com.mapping.relazioni.onetomany.services;

import com.mapping.relazioni.onetomany.entities.Libro;
import com.mapping.relazioni.onetomany.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro addlibro(Libro libro) {
        libroRepository.save(libro);
        return libro;
    }


    public List<Libro> getAllLibro() {
        List<Libro> libroList = libroRepository.findAll();
        return libroList;
    }

    public Optional<Libro> getLibro(Long id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        return libroOptional;
    }

    public Optional<Libro> updateLibro(Long id, Libro libro) {
        Optional<Libro> libroDaAggiornare = libroRepository.findById(id);
        if (libroDaAggiornare.isPresent()) {
            libroDaAggiornare.get().setTitolo(libro.getTitolo());
            libroRepository.save(libroDaAggiornare.get());
        } else {
            return Optional.empty();
        }
        return libroDaAggiornare;
    }

    public Optional<Libro> deleteLibroById(Long id) {
        Optional<Libro> libroDaCancellareOptional = libroRepository.findById(id);
        if (libroDaCancellareOptional.isPresent()) {
            libroRepository.delete(libroDaCancellareOptional.get());
            return libroDaCancellareOptional;
        } else {
            return Optional.empty();
        }

    }
}
