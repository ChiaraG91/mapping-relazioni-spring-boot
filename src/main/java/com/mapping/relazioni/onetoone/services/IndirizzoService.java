package com.mapping.relazioni.onetoone.services;

import com.mapping.relazioni.onetoone.entities.Indirizzo;
import com.mapping.relazioni.onetoone.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndirizzoService {

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    public Indirizzo addAddress(Indirizzo indirizzo){
       indirizzoRepository.save(indirizzo);
        return indirizzo;
    }

    public List<Indirizzo> getAllAddress() {
        List<Indirizzo> indirizzoList = indirizzoRepository.findAll();
        return indirizzoList;
    }

    public Optional<Indirizzo> getAddress(Long id) {
        Optional<Indirizzo> indirizzoOptional = indirizzoRepository.findById(id);
        return indirizzoOptional;
    }

    public Optional<Indirizzo> updateAddress(Long id,Indirizzo indirizzo){
        Optional<Indirizzo> indirizzoDaAggiornare = indirizzoRepository.findById(id);
        if (indirizzoDaAggiornare.isPresent()){
            indirizzoDaAggiornare.get().setVia(indirizzo.getVia());
            indirizzoDaAggiornare.get().setCitta(indirizzo.getCitta());
            indirizzoRepository.save(indirizzoDaAggiornare.get());
        } else {
            return Optional.empty();
        }
        return indirizzoDaAggiornare;
    }

    public Optional<Indirizzo> deleteAddressById(Long id){
        Optional<Indirizzo> indirizzoDaCancellareOptional = indirizzoRepository.findById(id);
        if(indirizzoDaCancellareOptional.isPresent()){
           indirizzoRepository.delete(indirizzoDaCancellareOptional.get());
            return indirizzoDaCancellareOptional;
        }else{
            return Optional.empty();
        }

    }

}
