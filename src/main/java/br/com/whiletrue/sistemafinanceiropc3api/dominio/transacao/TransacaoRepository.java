package br.com.whiletrue.sistemafinanceiropc3api.dominio.transacao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {

}
