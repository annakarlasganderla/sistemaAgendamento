package br.com.agenda.Model;

import java.time.LocalDateTime;

public class Historico extends AbstractEntily  {

    private Agenda agenda;
    private StatusAgenda statusAgenda;
    private Paciente paciente;
    private Secretaria secretaria;
    private LocalDateTime data;
    private String observacao;

    public Historico() {
    }

    public Historico(Agenda agenda, StatusAgenda statusAgenda, Paciente paciente, Secretaria secretaria, LocalDateTime data, String observacao) {
        this.agenda = agenda;
        this.statusAgenda = statusAgenda;
        this.paciente = paciente;
        this.secretaria = secretaria;
        this.data = data;
        this.observacao = observacao;
    }

    public Historico(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, Agenda agenda, StatusAgenda statusAgenda, Paciente paciente, Secretaria secretaria, LocalDateTime data, String observacao) {
        super(id, cadastro, atualizado, excluido);
        this.agenda = agenda;
        this.statusAgenda = statusAgenda;
        this.paciente = paciente;
        this.secretaria = secretaria;
        this.data = data;
        this.observacao = observacao;
    }


    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public StatusAgenda getStatusAgenda() {
        return statusAgenda;
    }

    public void setStatusAgendamento(StatusAgenda statusAgendamento) {
        this.statusAgenda = statusAgenda;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Historico{" +
                "agenda=" + agenda +
                ", statusAgendamento=" + statusAgenda +
                ", paciente=" + paciente +
                ", secretaria=" + secretaria +
                ", data=" + data +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
