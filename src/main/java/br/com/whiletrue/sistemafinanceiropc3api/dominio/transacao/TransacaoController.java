package br.com.whiletrue.sistemafinanceiropc3api.dominio.transacao;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransacaoController {

    // @Autowired
    // private TransacaoService transacaoService;

    final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping()
    public ResponseEntity<List<Transacao>> selectAll() {

        List<Transacao> listaDeTransacoes = this.transacaoService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(listaDeTransacoes);
    }

    @GetMapping("selectAllComPaginacao")
    public ResponseEntity<Page<Transacao>> selectAllComPaginacao(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.findAllComPaginacao(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> selectById(@PathVariable("id") UUID id) {

        Optional<Transacao> transacaoEncontrado = this.transacaoService.findById(id);

        if (!transacaoEncontrado.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transação não encontrada!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(transacaoEncontrado.get());
        }
    }

    @PostMapping()
    public ResponseEntity<Object> insert(@RequestBody @Valid TransacaoDto transacaoDaRequisicao) {

        Transacao transacao = new Transacao();
        BeanUtils.copyProperties(transacaoDaRequisicao, transacao);
        transacao.setAtivo(true);
        transacao.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        transacao.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        List<Transacao> todasTransacoes = transacaoService.findAll();

        if (todasTransacoes.size() > 0) {

            Transacao ultimaTransacao = todasTransacoes.get(todasTransacoes.size() - 1);

            if (transacao.getTipo().equals("ENTRADA")) {
                Double saldoFinal = ultimaTransacao.getSaldo() + transacao.getValor();
                transacao.setSaldo(saldoFinal);

            } else if (transacao.getTipo().equals("SAIDA")) {
                Double saldoFinal = ultimaTransacao.getSaldo() - transacao.getValor();
                transacao.setSaldo(saldoFinal);
            }

        } else {

            if (transacao.getTipo().equals("ENTRADA")) {
                Double saldoFinal = transacao.getValor();
                transacao.setSaldo(saldoFinal);

            } else if (transacao.getTipo().equals("SAIDA")) {
                Double saldoFinal = -transacao.getValor();
                transacao.setSaldo(saldoFinal);
            }

        }

        Transacao transacaoSalva = this.transacaoService.save(transacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoSalva);
    }

    @GetMapping("consultaUltimoSaldo")
    public ResponseEntity<Double> consultaUltimoSaldo() {

        return ResponseEntity.status(HttpStatus.OK).body(20.0);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") UUID idDaRequisicao,
            @RequestBody TransacaoDto transacaoDaRequisicao) {

        Optional<Transacao> transacaoOptional = this.transacaoService.findById(idDaRequisicao);

        if (!transacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transação não foi encontrada!");

        }

        Transacao transacao = new Transacao();
        BeanUtils.copyProperties(transacaoDaRequisicao, transacao);

        transacao.setId(transacaoOptional.get().getId());
        transacao.setCreatedAt(transacaoOptional.get().getCreatedAt());
        transacao.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        Transacao transacaoAtualizada = this.transacaoService.save(transacao);

        return ResponseEntity.status(HttpStatus.OK).body(transacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") UUID idDaRequisicao) {

        Optional<Transacao> transacaoOptional = this.transacaoService.findById(idDaRequisicao);

        if (!transacaoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transação não encontrada!");
        }
        transacaoService.delete(transacaoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Transação deletada com sucesso!");

    }
}
