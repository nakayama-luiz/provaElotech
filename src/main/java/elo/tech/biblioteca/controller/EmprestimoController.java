package elo.tech.biblioteca.controller;

import elo.tech.biblioteca.domain.Emprestimos;
import elo.tech.biblioteca.domain.dto.createEmprestimoDTO;
import elo.tech.biblioteca.domain.dto.updateEmprestimoDTO;
import elo.tech.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {

    @Autowired
    private  EmprestimoService EMPRESTIMO_SERVICE;

    public EmprestimoController(EmprestimoService EMPRESTIMO_SERVICE) {
        this.EMPRESTIMO_SERVICE = EMPRESTIMO_SERVICE;
    }

    @PostMapping
    public ResponseEntity<Emprestimos> create(@RequestBody createEmprestimoDTO novoEmprestimo){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.EMPRESTIMO_SERVICE.create(novoEmprestimo));

    }

    @PutMapping
    public ResponseEntity<Emprestimos> update(@RequestBody updateEmprestimoDTO emprestimo){
        return ResponseEntity.status(HttpStatus.OK).body(this.EMPRESTIMO_SERVICE.update(emprestimo));
    }

}
