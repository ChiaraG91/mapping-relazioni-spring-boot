package com.mapping.relazioni.onetomany.services;

import com.mapping.relazioni.onetomany.entities.Autore;
import com.mapping.relazioni.onetomany.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    public Autore addAutore(Autore autore){
        autoreRepository.save(autore);
        return autore;
    }


    public List<Autore> getAllAutori() {
        List<Autore> autoreList = autoreRepository.findAll();
        return autoreList;
    }

    public Optional<Autore> getAutore(Long id) {
        Optional<Autore> autoreOptional = autoreRepository.findById(id);
        return autoreOptional;
    }

    public Optional<Autore> updateEvent(Long id,Autore autore){
        Optional<Autore> autoreDaAggiornare = autoreRepository.findById(id);
        if (autoreDaAggiornare.isPresent()){
            autoreDaAggiornare.get().setNome(autore.getNome());
            autoreRepository.save(autoreDaAggiornare.get());
        } else {
            return Optional.empty();
        }
        return autoreDaAggiornare;
    }

    public Optional<Autore> deleteAutoreById(Long id){
        Optional<Autore> autoreDaCancellareOptional = autoreRepository.findById(id);
        if(autoreDaCancellareOptional.isPresent()){
            autoreRepository.delete(autoreDaCancellareOptional.get());
            return autoreDaCancellareOptional;
        }else{
            return Optional.empty();
        }

    }
}
