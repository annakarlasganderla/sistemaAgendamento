package br.com.agenda.Model;

public class Consulta extends Pessoa {

    private String horario;
    private Paciente paciente;
    private Medico medico;
    private boolean encaixe, ativo;

    public Consulta() {
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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

    public boolean isEncaixe() {
        return encaixe;
    }

    public void setEncaixe(boolean encaixe) {
        this.encaixe = encaixe;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "horario='" + horario + '\'' +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", encaixe=" + encaixe +
                ", ativo=" + ativo +
                '}';
    }
}
