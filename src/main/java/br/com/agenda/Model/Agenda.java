package br.com.agenda.Model;

import java.time.LocalDateTime;

public class Agenda extends AbstractEntily{

    private Paciente paciente;
    private Medico medico;
    private StatusAgenda statusAgenda;
    private LocalDateTime dataAgendamento;
    private Boolean encaixe;

    public Agenda() {
    }

    public Agenda(Paciente paciente, Medico medico, StatusAgenda statusAgendamento, LocalDateTime dataAgendamento, Boolean encaixe) {
        this.paciente = paciente;
        this.medico = medico;
        this.statusAgenda = statusAgenda;
        this.dataAgendamento = dataAgendamento;
        this.encaixe = encaixe;
    }

    public Agenda(Long id, LocalDateTime cadastro, LocalDateTime atualizado, LocalDateTime excluido, Paciente paciente, Medico medico, StatusAgenda statusAgenda, LocalDateTime dataAgendamento, Boolean encaixe) {
        super(id, cadastro, atualizado, excluido);
        this.paciente = paciente;
        this.medico = medico;
        this.statusAgenda = statusAgenda;
        this.dataAgendamento = dataAgendamento;
        this.encaixe = encaixe;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public StatusAgenda getStatusAgendamento() {
        return statusAgenda;
    }

    public void setStatusAgenda(StatusAgenda statusAgendamento) {
        this.statusAgenda = statusAgenda;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Boolean getEncaixe() {
        return encaixe;
    }

    public void setEncaixe(Boolean encaixe) {
        this.encaixe = encaixe;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "paciente=" + paciente +
                ", medico=" + medico +
                ", statusAgendamento=" + statusAgenda +
                ", dataAgendamento=" + dataAgendamento +
                ", encaixe=" + encaixe +
                '}';
    }
}
