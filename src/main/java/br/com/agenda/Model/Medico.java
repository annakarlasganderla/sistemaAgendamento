package br.com.agenda.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Medico extends Pessoa {

    private Especialidade especialidade;
    private String CRM;
    private BigDecimal porcenParticipacao;
    private String consultorio;

    public Medico() {
    }

    public Medico(String nome, String cpf, String rg, String cep, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo, Especialidade especialidade, String CRM, BigDecimal porcenParticipacao, String consultorio) {
        super(nome, cpf, rg, cep, telefone, email, login, senha, nacionalidade, sexo);
        this.especialidade = especialidade;
        this.CRM = CRM;
        this.porcenParticipacao = porcenParticipacao;
        this.consultorio = consultorio;
    }

    public Medico(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, String nome, String cpf, String rg, String cep, String telefone, String email, String login, String senha, String nacionalidade, Sexo sexo, Especialidade especialidade, String CRM, BigDecimal porcenParticipacao, String consultorio) {
        super(id, cadastro, atualizado, excluido, nome, cpf, rg, cep, telefone, email, login, senha, nacionalidade, sexo);
        this.especialidade = especialidade;
        this.CRM = CRM;
        this.porcenParticipacao = porcenParticipacao;
        this.consultorio = consultorio;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public BigDecimal getPorcenParticipacao() {
        return porcenParticipacao;
    }

    public void setPorcenParticipacao(BigDecimal porcenParticipacao) {
        this.porcenParticipacao = porcenParticipacao;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Medico{" +
                "especialidade=" + especialidade +
                ", CRM='" + CRM + '\'' +
                ", porcenParticipacao=" + porcenParticipacao +
                ", consultorio='" + consultorio + '\'' +
                '}';
    }
}
