package br.com.agenda.Service;

import br.com.agenda.Dao.ConsultaDao;
import br.com.agenda.Model.Consulta;

import java.util.List;

public class ConsultaService {

    ConsultaDao consultaDao = new ConsultaDao();

    public void insertConsulta(){
        consultaDao.insertConsulta();
    }

    public List<Consulta> findAllConsulta(){
        return null;
    }

    public List<Consulta> findByIdConsulta(){
        return null;
    }

    public void updateConsulta(){
        consultaDao.updateConsulta();
    }

    public void disableConsulta(){
        consultaDao.disableConsulta();
    }


}
