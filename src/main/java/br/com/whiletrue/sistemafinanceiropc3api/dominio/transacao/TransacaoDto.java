package br.com.whiletrue.sistemafinanceiropc3api.dominio.transacao;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.whiletrue.sistemafinanceiropc3api.dominio.usuario.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoDto {

    private Boolean ativo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NotBlank(message = "A variável 'Tipo' não pode ser nulo ou vazio!")
    private String tipo;

    @NotNull
    private Double valor;

    private Double saldo;

    private String descricao;

    @NotNull
    private Usuario usuario;

}
