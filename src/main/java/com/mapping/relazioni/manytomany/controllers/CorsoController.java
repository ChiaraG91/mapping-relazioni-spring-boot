package com.mapping.relazioni.manytomany.controllers;

import com.mapping.relazioni.manytomany.entities.Corso;
import com.mapping.relazioni.manytomany.entities.Student;
import com.mapping.relazioni.manytomany.services.CorsoService;
import com.mapping.relazioni.manytomany.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/corso")
public class CorsoController {

    @Autowired
    private CorsoService corsoService;

    @PostMapping("/addcorso")
    public ResponseEntity<Corso> addCorso(@RequestBody Corso corso){
        corsoService.addCorso(corso);
        return ResponseEntity.ok().body(corso);
    }

    @GetMapping("/getlist")
    public ResponseEntity<List<Corso>> getAllCorsi(){
        List<Corso> allCorsi = corsoService.getAllCorsi();
        return ResponseEntity.ok().body(allCorsi);
    }

    @GetMapping("/getcorso/{id}")
    public ResponseEntity<Optional<Corso>> getCorso(@PathVariable Long id){
        Optional<Corso> corsoOptional = corsoService.getCorso(id);
        return ResponseEntity.ok().body(corsoOptional);
    }

    @PutMapping("/updatecorso/{id}")
    public ResponseEntity<Corso> updateCorsoById(@RequestBody Corso corso,@PathVariable Long id){
        Optional<Corso> corsoOptional = corsoService.updateCorso(id,corso);
        if(corsoOptional.isPresent()){
            return ResponseEntity.ok().body(corsoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteid")
    public ResponseEntity<Optional<Corso>> deleteCorsoById(@RequestParam Long id){
        Optional<Corso> corsoDaCancellare = corsoService.deleteCorsoById(id);
        if(corsoDaCancellare.isPresent()){
            return ResponseEntity.ok().body(corsoDaCancellare);
        }
        return ResponseEntity.notFound().build();

    }
}
