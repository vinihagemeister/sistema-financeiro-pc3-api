// package br.com.whiletrue.sistemafinanceiropc3api.dominio.transacao;

// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.Optional;
// import java.util.UUID;

// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// // @RestController
// // @RequestMapping("/transacaosembanco")
// public class TransacaoControllerSemBanco {

// public TransacaoControllerSemBanco() {
// }

// private List<Transacao> transacoes = new ArrayList<>();

// @GetMapping()
// public List<Transacao> selectAll() {
// return transacoes;
// }

// @PostMapping()
// public Transacao insert(@RequestBody Transacao transacaoDaRequisicao) {

// transacoes.add(transacaoDaRequisicao);

// return transacaoDaRequisicao;

// // Transacao transacao = new Transacao();
// // transacao.setAtivo(true);
// // transacao.setCreatedAt(LocalDateTime.now());
// // transacao.setUpdatedAt(LocalDateTime.now());
// // transacao.setTipo("ENTRADA");
// // transacao.setValor(50.0);
// // transacao.setSaldo(100.0);
// // transacao.setDescricao("Descrição da transação");

// // transacoes.add(transacao);

// }

// @PutMapping("/{id}")
// public Transacao update(@PathVariable("id") UUID idDaRequisicao, @RequestBody
// Transacao transacaoDaRequisicao) {

// // Optional<Transacao> opTransacao = transacoes.stream().filter(transacao ->
// // transacao.getId() == idDaRequisicao).findFirst();

// for (int i = 0; i < transacoes.size(); i++) {

// if (transacoes.get(i).getId().equals(idDaRequisicao)) {
// transacoes.set(i, transacaoDaRequisicao);
// return transacaoDaRequisicao;
// }

// }

// return null;

// }

// @DeleteMapping("/{id}")
// public Transacao delete(@PathVariable("id") UUID idDaRequisicao) {

// for (int i = 0; i < transacoes.size(); i++) {

// if (transacoes.get(i).getId().equals(idDaRequisicao)) {
// Transacao t = transacoes.get(i);
// transacoes.remove(i);
// return t;
// }

// }

// // Transacao transacao = transacoes.get(transacoes.size() - 1);
// // transacoes.remove(transacoes.size() - 1);
// return null;
// }

// // @GetMapping
// // public String index1() {
// // return "Hello World!!";
// // }

// // @GetMapping("/index2")
// // public String index2() {
// // return "Index 2 Hello!";
// // }
// }
