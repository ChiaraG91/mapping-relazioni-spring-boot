package com.mapping.relazioni.onetomany.controllers;

import com.mapping.relazioni.onetomany.entities.Autore;
import com.mapping.relazioni.onetomany.entities.Libro;
import com.mapping.relazioni.onetomany.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/addautore")
    public ResponseEntity<Autore> addAutore(@RequestBody Autore autore){
        autoreService.addAutore(autore);
        return ResponseEntity.ok().body(autore);
    }

    @GetMapping("/getlist")
    public ResponseEntity<List<Autore>> getAllautori(){
        List<Autore> allAutori = autoreService.getAllAutori();
        return ResponseEntity.ok().body(allAutori);
    }

    @GetMapping("/getautore/{id}")
    public ResponseEntity<Optional<Autore>> getAutore(@PathVariable Long id){
        Optional<Autore> autoreOptional = autoreService.getAutore(id);
        return ResponseEntity.ok().body(autoreOptional);
    }

    @PutMapping("/updateautore/{id}")
    public ResponseEntity<Autore> updateAutoreById(@RequestBody Autore autore,@PathVariable Long id){
        Optional<Autore> autoreOptional = autoreService.updateEvent(id,autore);
        if(autoreOptional.isPresent()){
            return ResponseEntity.ok().body(autoreOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteid")
    public ResponseEntity<Optional<Autore>> deleteAutoreById(@RequestParam Long id){
        Optional<Autore> autoreDaCancellare = autoreService.deleteAutoreById(id);
        if(autoreDaCancellare.isPresent()){
            return  ResponseEntity.ok().body(autoreDaCancellare);
        }
        return ResponseEntity.notFound().build();

    }

}
