package elo.tech.biblioteca.controller;


import elo.tech.biblioteca.domain.Autor;
import elo.tech.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autor")
@CrossOrigin
public class AutorController {
    @Autowired
    private AutorService autorService;

    AutorController(AutorService autorService){
        this.autorService= autorService;
    }


    @PostMapping
    public ResponseEntity<Autor> create(@RequestBody Autor autor){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.autorService.create(autor));
    }

}
