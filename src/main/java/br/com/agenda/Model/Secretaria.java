package br.com.agenda.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Secretaria extends Pessoa {

    private BigDecimal salario;
    private LocalDateTime dataContratacao;
    private String pis;

    public Secretaria() {
    }

    public Secretaria(String nome, String cpf, String rg, String cep, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo, BigDecimal salario, LocalDateTime dataContratacao, String pis) {
        super(nome, cpf, rg, cep, telefone, email, login, senha, nacionalidade, sexo);
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.pis = pis;
    }

    public Secretaria(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nome, String cpf, String rg, String cep, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo, BigDecimal salario, LocalDateTime dataContratacao, String pis) {
        super(id, cadastro, atualizado, excluido, nome, cpf, rg, cep, telefone, email, login, senha, nacionalidade, sexo);
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.pis = pis;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDateTime getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDateTime dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Secretaria{" +
                "salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", pis='" + pis + '\'' +
                '}';
    }
}
