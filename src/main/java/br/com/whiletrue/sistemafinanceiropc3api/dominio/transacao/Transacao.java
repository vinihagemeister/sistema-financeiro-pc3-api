package br.com.whiletrue.sistemafinanceiropc3api.dominio.transacao;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private Boolean ativo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String tipo;
    private Double valor;
    private Double saldo;
    private String descricao;

    // public Transacao() {
    // }

    // public Transacao(UUID id, Boolean ativo, LocalDateTime createdAt,
    // LocalDateTime updatedAt, String tipo,
    // Double valor, Double saldo, String descricao) {
    // this.id = id;
    // this.ativo = ativo;
    // this.createdAt = createdAt;
    // this.updatedAt = updatedAt;
    // this.tipo = tipo;
    // this.valor = valor;
    // this.saldo = saldo;
    // this.descricao = descricao;
    // }

    // public UUID getId() {
    // return id;
    // }
    // public void setId(UUID id) {
    // this.id = id;
    // }
    // public Boolean getAtivo() {
    // return ativo;
    // }
    // public void setAtivo(Boolean ativo) {
    // this.ativo = ativo;
    // }
    // public LocalDateTime getCreatedAt() {
    // return createdAt;
    // }
    // public void setCreatedAt(LocalDateTime createdAt) {
    // this.createdAt = createdAt;
    // }
    // public LocalDateTime getUpdatedAt() {
    // return updatedAt;
    // }
    // public void setUpdatedAt(LocalDateTime updatedAt) {
    // this.updatedAt = updatedAt;
    // }
    // public String getTipo() {
    // return tipo;
    // }
    // public void setTipo(String tipo) {
    // this.tipo = tipo;
    // }
    // public Double getValor() {
    // return valor;
    // }
    // public void setValor(Double valor) {
    // this.valor = valor;
    // }
    // public Double getSaldo() {
    // return saldo;
    // }
    // public void setSaldo(Double saldo) {
    // this.saldo = saldo;
    // }
    // public String getDescricao() {
    // return descricao;
    // }
    // public void setDescricao(String descricao) {
    // this.descricao = descricao;
    // }

}
