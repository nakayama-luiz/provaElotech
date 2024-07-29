package elo.tech.biblioteca.service;

import elo.tech.biblioteca.domain.Usuario;
import elo.tech.biblioteca.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepositoy;

    public UsuarioService(UsuarioRepository usuarioRepositoy) {
        this.usuarioRepositoy = usuarioRepositoy;
    }

    public Usuario create(Usuario usuario){
        return this.usuarioRepositoy.save(usuario);
    }

    public Usuario findById(Long id){
        return this.usuarioRepositoy.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
    }

    public void delete(Long id){
        this.usuarioRepositoy.deleteById(id);
    }

    public Usuario update(Usuario usuario){
        return this.usuarioRepositoy.save(usuario);
    }

}
