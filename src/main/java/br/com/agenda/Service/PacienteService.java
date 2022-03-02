package br.com.agenda.Service;

import br.com.agenda.Dao.PacienteDao;
import br.com.agenda.Model.Paciente;

import java.sql.SQLException;
import java.util.List;

public class PacienteService {

    PacienteDao pacienteDao = new PacienteDao();

    public PacienteService() throws SQLException {
    }

    public void insertPaciente(){

    }

    public List<Paciente> findAllPaciente(){
        return null;
    }

    public List<Paciente> findByIdPaciente(){
        return null;
    }

    public void updatePaciente(){

    }

    public void disablePaciente() {

    }

}
