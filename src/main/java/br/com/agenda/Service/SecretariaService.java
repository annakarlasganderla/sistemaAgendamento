package br.com.agenda.Service;

import br.com.agenda.Dao.SecretariaDao;
import br.com.agenda.Model.Secretaria;

import java.sql.SQLException;
import java.util.List;

public class SecretariaService {

    SecretariaDao secretariaDao = new SecretariaDao();

    public SecretariaService() throws SQLException {
    }

    public void insertSecretaria(){

    }

    public List<Secretaria> findAllSecretaria(){
        return null;
    }

    public List<Secretaria> findByIdSecretaria(){
        return null;
    }

    public void updateSecretaria(){

    }

    public void disableSecretaria() {

    }
}
