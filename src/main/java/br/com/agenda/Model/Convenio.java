package br.com.agenda.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Convenio extends AbstractEntily{

    private String nome;
    private BigDecimal valor;

    public Convenio() {
    }

    public Convenio(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Convenio(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nome, BigDecimal valor) {
        super(id, cadastro, atualizado, excluido);
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Convenio{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}

