package br.com.agenda.Dao;

import br.com.agenda.Factory.ConnectionFactory;
import br.com.agenda.Model.Especialidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDao {

    private static Connection connection;

    public EspecialidadeDao() throws SQLException {
        this.connection = ConnectionFactory.getConexao();
    }

    public void insertEspecialidade(Especialidade especialidade){

        String sql = "INSERT INTO especialidade (cadastrado,nome) VALUES(now(),?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, especialidade.getNome());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                especialidade.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }


    public List<Especialidade> findAllEspecialidade(){

        String sql = "SELECT * FROM especialidade";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Especialidade> listaDeEspecialidades = new ArrayList<>();

            while (resultSet.next()){
                Especialidade especialidade = new Especialidade();

                especialidade.setId(resultSet.getLong("id"));
                especialidade.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    especialidade.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    especialidade.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                especialidade.setNome(resultSet.getString("nome"));

                listaDeEspecialidades.add(especialidade);
            }

            return listaDeEspecialidades;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Especialidade findByIdEspecialidade(Long especialidade_id){

        String sql = "SELECT * FROM especialidade WHERE id = ?";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, especialidade_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Especialidade especialidade = new Especialidade();

                especialidade.setId(resultSet.getLong("id"));
                especialidade.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    especialidade.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    especialidade.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                especialidade.setNome(resultSet.getString("nome"));

                return especialidade;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateEspecialidade(Especialidade especialidade){

        String sql = "UPDATE especialidade SET atualizado = now(),nome = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,especialidade.getNome());
            preparedStatement.setLong(2, especialidade.getId());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disableEspecialidade(Especialidade especialidade){

        String sql = "UPDATE especialidade SET excluido = now() WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, especialidade.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
