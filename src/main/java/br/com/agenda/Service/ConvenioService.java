package br.com.agenda.Service;

import br.com.agenda.Dao.ConvenioDao;
import br.com.agenda.Model.Convenio;

import java.sql.SQLException;
import java.util.List;

public class ConvenioService {

    ConvenioDao convenioDao = new ConvenioDao();

    public ConvenioService() throws SQLException {
    }

    public void insertConvenio(){

    }

    public List<Convenio> findAllConvenio(){
        return null;
    }

    public List<Convenio> findByIdConvenio(){
        return null;
    }

    public void updateConvenio(){

    }

    public void disableConvenio() {

    }

}
