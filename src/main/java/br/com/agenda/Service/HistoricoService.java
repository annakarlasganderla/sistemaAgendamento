package br.com.agenda.Service;

import br.com.agenda.Dao.HistoricoDao;
import br.com.agenda.Model.Historico;

import java.sql.SQLException;
import java.util.List;

public class HistoricoService {

    HistoricoDao historicoDao = new HistoricoDao();

    public HistoricoService() throws SQLException {
    }

    public void insertHistorico(){

    }

    public List<Historico> findAllHistorico(){
        return null;
    }

    public List<Historico> findByIdHistorico(){
        return null;
    }

    public void updateHistorico(){

    }

    public void disableHistorico() {

    }

}
