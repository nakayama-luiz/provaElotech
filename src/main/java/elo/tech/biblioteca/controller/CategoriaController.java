package elo.tech.biblioteca.controller;

import elo.tech.biblioteca.domain.Categorias;
import elo.tech.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categorias> create(@RequestBody Categorias categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoriaService.create(categoria));
    }


    @GetMapping("/{id}")
    public  ResponseEntity<Categorias> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(this.categoriaService.findById(id));
    }

}
