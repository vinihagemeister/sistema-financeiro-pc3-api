package br.com.whiletrue.sistemafinanceiropc3api.dominio.usuario;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

}
