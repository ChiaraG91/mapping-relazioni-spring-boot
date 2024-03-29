package com.mapping.relazioni.onetomany.controllers;

import com.mapping.relazioni.onetomany.entities.Libro;
import com.mapping.relazioni.onetomany.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping("/addlibro")
    public ResponseEntity<Libro> addLibro(@RequestBody Libro libro){
        libroService.addlibro(libro);
        return ResponseEntity.ok().body(libro);
    }

    @GetMapping("/getlist")
    public ResponseEntity<List<Libro>> getAllLibri(){
        List<Libro> allBooks = libroService.getAllLibro();
        return ResponseEntity.ok().body(allBooks);
    }

    @GetMapping("/getlibro/{id}")
    public ResponseEntity<Optional<Libro>> getLibro(@PathVariable Long id){
        Optional<Libro> libroOptional = libroService.getLibro(id);
        return ResponseEntity.ok().body(libroOptional);
    }

    @PutMapping("/updatelibro/{id}")
    public ResponseEntity<Libro> updateLibroById(@RequestBody Libro libro,@PathVariable Long id){
        Optional<Libro> libroOptional = libroService.updateLibro(id,libro);
        if(libroOptional.isPresent()){
            return ResponseEntity.ok().body(libroOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteid")
    public ResponseEntity<Optional<Libro>> deleteLibroById(@RequestParam Long id){
        Optional<Libro> libroDaCancellare = libroService.deleteLibroById(id);
        if(libroDaCancellare.isPresent()){
            return ResponseEntity.ok().body(libroDaCancellare);
        }
        return ResponseEntity.notFound().build();

    }
}
