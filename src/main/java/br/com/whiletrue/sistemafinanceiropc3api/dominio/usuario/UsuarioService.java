package br.com.whiletrue.sistemafinanceiropc3api.dominio.usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired // injetado de outra forma diferente do construtor
    private UsuarioRepository usuarioRepository;

    // final UsuarioRepository usuarioRepository;

    // public UsuarioService(UsuarioRepository tr) {
    // this.usuarioRepository = tr;
    // }

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(UUID id) {
        return this.usuarioRepository.findById(id);
    }

    @Transactional
    public Usuario save(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Transactional
    public void delete(Usuario usuario) {
        this.usuarioRepository.delete(usuario);
    }

}
