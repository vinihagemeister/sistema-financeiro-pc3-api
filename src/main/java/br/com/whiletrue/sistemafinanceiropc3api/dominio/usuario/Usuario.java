package br.com.whiletrue.sistemafinanceiropc3api.dominio.usuario;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.whiletrue.sistemafinanceiropc3api.dominio.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario extends Model implements Serializable {

    @Column(nullable = false)
    private String nome;

    private String sobrenome;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String cpf;

}
