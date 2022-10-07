package br.com.whiletrue.sistemafinanceiropc3api.dominio.usuario;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UsuarioController {

    // @Autowired
    // private UsuarioService usuarioService;

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> selectAll() {

        List<Usuario> listaDeTransacoes = this.usuarioService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(listaDeTransacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> selectById(@PathVariable("id") UUID id) {

        Optional<Usuario> usuarioEncontrado = this.usuarioService.findById(id);

        if (!usuarioEncontrado.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transação não encontrada!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioEncontrado.get());
        }
    }

    @PostMapping()
    public ResponseEntity<Object> insert(@RequestBody @Valid UsuarioDto usuarioDaRequisicao) {

        Usuario usuario = new Usuario();
        // usuario.setDescricao(usuarioDaRequisicao.getDescricao());
        // usuario.setTipo(usuarioDaRequisicao.getTipo());
        // usuario.setValor(usuarioDaRequisicao.getValor());
        // usuario.setSaldo(usuarioDaRequisicao.getSaldo());

        BeanUtils.copyProperties(usuarioDaRequisicao, usuario);

        usuario.setAtivo(true);
        usuario.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        usuario.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        Usuario usuarioSalva = this.usuarioService.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") UUID idDaRequisicao,
            @RequestBody UsuarioDto usuarioDaRequisicao) {

        Optional<Usuario> usuarioOptional = this.usuarioService.findById(idDaRequisicao);

        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transação não foi encontrada!");

        }

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDaRequisicao, usuario);

        usuario.setId(usuarioOptional.get().getId());
        usuario.setCreatedAt(usuarioOptional.get().getCreatedAt());
        usuario.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        Usuario usuarioAtualizada = this.usuarioService.save(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") UUID idDaRequisicao) {

        Optional<Usuario> usuarioOptional = this.usuarioService.findById(idDaRequisicao);

        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        usuarioService.delete(usuarioOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");

    }
}
