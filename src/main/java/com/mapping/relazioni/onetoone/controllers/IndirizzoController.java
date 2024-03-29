package com.mapping.relazioni.onetoone.controllers;

import com.mapping.relazioni.onetoone.entities.Indirizzo;
import com.mapping.relazioni.onetoone.services.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/indirizzo")
public class IndirizzoController {

    @Autowired
    private IndirizzoService indirizzoService;

    @PostMapping("/addaddress")
    public ResponseEntity<Indirizzo> addAddress(@RequestBody Indirizzo indirizzo){
        indirizzoService.addAddress(indirizzo);
        return ResponseEntity.ok().body(indirizzo);
    }

    @GetMapping("/getlist")
    public ResponseEntity<List<Indirizzo>> getAllAddress(){
        List<Indirizzo> allAddress = indirizzoService.getAllAddress();
        return ResponseEntity.ok().body(allAddress);
    }

    @GetMapping("/getaddress/{id}")
    public ResponseEntity<Optional<Indirizzo>> getAddress(@PathVariable Long id){
        Optional<Indirizzo> indirizzoOptional = indirizzoService.getAddress(id);
        return ResponseEntity.ok().body(indirizzoOptional);
    }

    @PutMapping("/updateaddress/{id}")
    public ResponseEntity<Indirizzo> updateAddressById(@RequestBody Indirizzo indirizzo, @PathVariable Long id){
        Optional<Indirizzo> indirizzoOptional = indirizzoService.updateAddress(id,indirizzo);
        if(indirizzoOptional.isPresent()){
            return ResponseEntity.ok().body(indirizzoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteid")
    public ResponseEntity<Optional<Indirizzo>> deleteAddressById(@RequestParam Long id){
        Optional<Indirizzo> indirizzoDaCancellare = indirizzoService.deleteAddressById(id);
        if(indirizzoDaCancellare.isPresent()){
            return ResponseEntity.ok().body(indirizzoDaCancellare);
        }
        return ResponseEntity.notFound().build();

    }


}
