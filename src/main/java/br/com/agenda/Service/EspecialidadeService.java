package br.com.agenda.Service;

import br.com.agenda.Dao.EspecialidadeDao;
import br.com.agenda.Model.Especialidade;

import java.sql.SQLException;
import java.util.List;

public class EspecialidadeService {

    EspecialidadeDao especialidadeDao = new EspecialidadeDao();

    public EspecialidadeService() throws SQLException {
    }

    public void insertEspecialidade(Especialidade especialidade){
        especialidadeDao.insertEspecialidade(especialidade);
    }

    public List<Especialidade> findAllEspecialidade(){
        return null;
    }

    public List<Especialidade> findByIdEspecialidade(){
        return null;
    }

    public void updateEspecialidade(){
    }

    public void disableEspecialidade() {

    }

}
