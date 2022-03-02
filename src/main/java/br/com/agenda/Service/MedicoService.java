package br.com.agenda.Service;

import br.com.agenda.Dao.MedicoDao;
import br.com.agenda.Model.Medico;

import java.sql.SQLException;
import java.util.List;

public class MedicoService {

    MedicoDao medicoDao = new MedicoDao();

    public MedicoService() throws SQLException {
    }

    public void insertMedico(){

    }

    public List<Medico> findAllMedico(){
        return null;
    }

    public List<Medico> findByIdMedico(){
        return null;
    }

    public void updateMedico(){

    }

    public void disableMedico() {

    }

}
