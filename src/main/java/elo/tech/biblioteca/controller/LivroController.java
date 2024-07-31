package elo.tech.biblioteca.controller;

import elo.tech.biblioteca.domain.GoogleBookDataResponse;
import elo.tech.biblioteca.domain.Livros;
import elo.tech.biblioteca.service.LivroService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import elo.tech.biblioteca.domain.dto.createLivroDTO;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
@CrossOrigin
public class LivroController {

    @Autowired
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    ResponseEntity<Livros> create(@RequestBody createLivroDTO livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.livroService.create(livro));
    }

    @GetMapping("/recomendar/usuario/{usuario_id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "302", description = "Livros que usuário não leu, mas gostaria.")
    })
    public ResponseEntity<List<Livros>> recomendarLivrosPorUsuario(@PathVariable Long usuario_id){
        return ResponseEntity.status(HttpStatus.FOUND).body(this.livroService.recomendar(usuario_id));
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "302", description = "Procura nome pelo ID")
    })
    public ResponseEntity<Livros> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(this.livroService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.livroService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<Livros> update(@RequestBody Livros livro){
        return ResponseEntity.status(HttpStatus.OK).body(this.livroService.update(livro));
    }

    @PostMapping("/integracao/novo-livro")
    public ResponseEntity<Livros> createLivroIntegracao(@RequestBody GoogleBookDataResponse bookDataResponse){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.livroService.createLivroGoogleApi(bookDataResponse));
    }
}
