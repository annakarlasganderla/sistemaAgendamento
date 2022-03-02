package br.com.agenda.Model;

import java.time.LocalDateTime;

public class Paciente extends Pessoa{

    private TipoAtendimento tipoAtendimento;
    private Convenio convenio;
    private String numeroCartaoConvenio;
    private LocalDateTime dataVencimento;

    public Paciente() {
    }

    public Paciente(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nome, String cpf, String rg, String cep, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo, TipoAtendimento tipoAtendimento, Convenio convenio, String numeroCartaoConvenio, LocalDateTime dataVencimento) {
        super(id, cadastro, atualizado, excluido, nome, cpf, rg, cep, telefone, email, login, senha, nacionalidade, sexo);
        this.tipoAtendimento = tipoAtendimento;
        this.convenio = convenio;
        this.numeroCartaoConvenio = numeroCartaoConvenio;
        this.dataVencimento = dataVencimento;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getNumeroCartaoConvenio() {
        return numeroCartaoConvenio;
    }

    public void setNumeroCartaoConvenio(String numeroCartaoConvenio) {
        this.numeroCartaoConvenio = numeroCartaoConvenio;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Paciente{" +
                "tipoAtendimento=" + tipoAtendimento +
                ", convenio=" + convenio +
                ", numeroCartaoConvenio='" + numeroCartaoConvenio + '\'' +
                ", dataVencimento=" + dataVencimento +
                '}';
    }
}
