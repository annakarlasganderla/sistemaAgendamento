package br.com.agenda.Service;

import br.com.agenda.Dao.AgendaDao;
import br.com.agenda.Model.Agenda;

import java.sql.SQLException;
import java.util.List;

public class AgendaService {

    AgendaDao agendaDao = new AgendaDao();

    public AgendaService() throws SQLException {
    }

    public void insertAgendamento(){

    }

    public List<Agenda> findAllAgendamento(){
        return null;
    }

    public List<Agenda> findByIdAgendamento(){
        return null;
    }

    public void updateAgendamento(){

    }

    public void disableAgendamento(){

    }


}
