package br.com.whiletrue.sistemafinanceiropc3api.dominio.transacao;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private Double saldo;

    private String descricao;

}
