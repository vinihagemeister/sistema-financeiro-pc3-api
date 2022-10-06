package br.com.whiletrue.sistemafinanceiropc3api.dominio.transacao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired // injetado de outra forma diferente do construtor
    private TransacaoRepository transacaoRepository;

    // final TransacaoRepository transacaoRepository;

    // public TransacaoService(TransacaoRepository tr) {
    // this.transacaoRepository = tr;
    // }

    public List<Transacao> findAll() {
        return this.transacaoRepository.findAll();
    }

    public Optional<Transacao> findById(UUID id) {
        return this.transacaoRepository.findById(id);
    }

    @Transactional
    public Transacao save(Transacao transacao) {
        return this.transacaoRepository.save(transacao);
    }

    @Transactional
    public void delete(Transacao transacao) {
        this.transacaoRepository.delete(transacao);
    }

}
