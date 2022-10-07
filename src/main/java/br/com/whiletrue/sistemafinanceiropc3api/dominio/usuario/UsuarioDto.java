package br.com.whiletrue.sistemafinanceiropc3api.dominio.usuario;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    private Boolean ativo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NotBlank
    // @Size(max = 150)
    private String nome;
    private String sobrenome;

    @NotBlank
    private String username;

    // @Min(11)
    // @Max(13)
    @NotBlank
    @Length(min = 11, max = 13)
    private String cpf;

}
