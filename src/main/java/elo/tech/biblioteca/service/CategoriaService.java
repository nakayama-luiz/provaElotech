package elo.tech.biblioteca.service;


import elo.tech.biblioteca.domain.Categorias;
import elo.tech.biblioteca.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categorias create(Categorias categoria){
        return this.categoriaRepository.save(categoria);
    }

    public Categorias findById(Long id){
        return this.categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada."));
    }
}
