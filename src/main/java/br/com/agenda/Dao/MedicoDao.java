package br.com.agenda.Dao;

import br.com.agenda.Factory.ConnectionFactory;
import br.com.agenda.Model.Especialidade;
import br.com.agenda.Model.Medico;
import br.com.agenda.Model.Sexo;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDao {

    private static Connection connection;

    public MedicoDao() throws SQLException {
        this.connection = ConnectionFactory.getConexao();
    }

    public void insertMedico(Medico medico){

        String sql = "INSERT INTO medico (cadastrado,nome,email,login,senha,cpf,rg,cep,telefone,nacionalidade,sexo," +
                "id_especialidade,crm,consultorio,porcen_participacao) " +
                "VALUES(now(),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getEmail());
            preparedStatement.setString(3, medico.getLogin());
            preparedStatement.setString(4, medico.getSenha());
            preparedStatement.setString(5, medico.getCpf());
            preparedStatement.setString(6, medico.getRg());
            preparedStatement.setString(7, medico.getCep());
            preparedStatement.setString(8, medico.getTelefone());
            preparedStatement.setString(9, medico.getNacionalidade());
            preparedStatement.setString(10, medico.getSexo().valor);
            preparedStatement.setLong(11, medico.getEspecialidade().getId());
            preparedStatement.setString(12, medico.getCRM());
            preparedStatement.setString(13, medico.getConsultorio());
            preparedStatement.setBigDecimal(14, medico.getPorcenParticipacao());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                medico.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Medico> findAllMedico(){

        String sql = "SELECT * FROM medico";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Medico> listaDeMedicos = new ArrayList<>();

            while (resultSet.next()){
                Medico medico = new Medico();

                medico.setId(resultSet.getLong("id"));
                medico.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    medico.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    medico.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                medico.setNome(resultSet.getString("nome"));
                medico.setEmail(resultSet.getString("email"));
                medico.setLogin(resultSet.getString("login"));
                medico.setSenha(resultSet.getString("senha"));
                medico.setCpf(resultSet.getString("cpf"));
                medico.setRg(resultSet.getString("rg"));
                medico.setCep(resultSet.getString("cep"));
                medico.setTelefone(resultSet.getString("telefone"));
                medico.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        medico.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        medico.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        medico.setSexo(Sexo.outros);
                        break;
                }
                EspecialidadeDao especialidadeDao = new EspecialidadeDao();
                Especialidade especialidade = especialidadeDao.findByIdEspecialidade(resultSet.getLong("id_especialidade"));
                medico.setEspecialidade(especialidade);

                medico.setCRM(resultSet.getString("crm"));
                medico.setConsultorio(resultSet.getString("consultorio"));
                medico.setPorcenParticipacao(resultSet.getBigDecimal("porcen_participacao"));

                listaDeMedicos.add(medico);
            }

            return listaDeMedicos;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Medico findByIdMedico(Long medico_id){

        String sql = "SELECT * FROM medico WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, medico_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Medico medico = new Medico();

                medico.setId(resultSet.getLong("id"));
                medico.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    medico.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    medico.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                medico.setNome(resultSet.getString("nome"));
                medico.setEmail(resultSet.getString("email"));
                medico.setLogin(resultSet.getString("login"));
                medico.setSenha(resultSet.getString("senha"));
                medico.setCpf(resultSet.getString("cpf"));
                medico.setRg(resultSet.getString("rg"));
                medico.setCep(resultSet.getString("cep"));
                medico.setTelefone(resultSet.getString("telefone"));
                medico.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        medico.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        medico.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        medico.setSexo(Sexo.outros);
                        break;
                }
                EspecialidadeDao especialidadeDao = new EspecialidadeDao();
                Especialidade especialidade = especialidadeDao.findByIdEspecialidade(resultSet.getLong("id_especialidade"));
                medico.setEspecialidade(especialidade);

                medico.setCRM(resultSet.getString("crm"));
                medico.setConsultorio(resultSet.getString("consultorio"));
                medico.setPorcenParticipacao(resultSet.getBigDecimal("porcen_participacao"));

                return medico;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateMedico(Medico medico){

        String sql = "UPDATE medico SET atualizado = now(),nome = ?,email = ?,login = ?,senha = ?," +
                "cpf = ?,rg = ?,cep = ?,telefone = ?,nacionalidade = ?,sexo = ?,id_especialidade = ?," +
                "crm = ?,consultorio = ?,porcen_participacao = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,medico.getNome());
            preparedStatement.setString(2,medico.getEmail());
            preparedStatement.setString(3,medico.getLogin());
            preparedStatement.setString(4,medico.getSenha());
            preparedStatement.setString(5,medico.getCpf());
            preparedStatement.setString(6,medico.getRg());
            preparedStatement.setString(7,medico.getCep());
            preparedStatement.setString(8,medico.getTelefone());
            preparedStatement.setString(9,medico.getNacionalidade());
            preparedStatement.setString(10,medico.getSexo().valor);
            preparedStatement.setLong(11,medico.getEspecialidade().getId());
            preparedStatement.setString(12,medico.getCRM());
            preparedStatement.setString(13,medico.getConsultorio());
            preparedStatement.setBigDecimal(14,medico.getPorcenParticipacao());
            preparedStatement.setLong(15, medico.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disableMedico(Medico medico){

        String sql = "UPDATE medico SET excluido = now() WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, medico.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
