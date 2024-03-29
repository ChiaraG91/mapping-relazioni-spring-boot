package com.mapping.relazioni.manytomany.services;

import com.mapping.relazioni.manytomany.entities.Corso;
import com.mapping.relazioni.manytomany.entities.Student;
import com.mapping.relazioni.manytomany.repositories.CorsoRepository;
import com.mapping.relazioni.manytomany.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorsoService {

    @Autowired
    private CorsoRepository corsoRepository;

    public Corso addCorso(Corso corso) {
        corsoRepository.save(corso);
        return corso;
    }

    public List<Corso> getAllCorsi() {
        List<Corso> corsiList = corsoRepository.findAll();
        return corsiList;
    }

    public Optional<Corso> getCorso(Long id) {
        Optional<Corso> corsoOptional = corsoRepository.findById(id);
        return corsoOptional;
    }

    public Optional<Corso> updateCorso(Long id, Corso corso) {
        Optional<Corso> corsoDaAggiornare = corsoRepository.findById(id);
        if (corsoDaAggiornare.isPresent()) {
            corsoDaAggiornare.get().setNome(corso.getNome());
            corsoRepository.save(corsoDaAggiornare.get());
        } else {
            return Optional.empty();
        }
        return corsoDaAggiornare;
    }

    public Optional<Corso> deleteCorsoById(Long id) {
        Optional<Corso> corsoDaCancellareOptional = corsoRepository.findById(id);
        if (corsoDaCancellareOptional.isPresent()) {
            corsoRepository.delete(corsoDaCancellareOptional.get());
            return corsoDaCancellareOptional;
        } else {
            return Optional.empty();
        }

    }
}