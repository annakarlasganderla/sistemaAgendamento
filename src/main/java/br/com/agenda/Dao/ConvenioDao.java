package br.com.agenda.Dao;

import br.com.agenda.Factory.ConnectionFactory;
import br.com.agenda.Model.Convenio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConvenioDao {

    private static Connection connection;

    public ConvenioDao() throws SQLException {
        this.connection = ConnectionFactory.getConexao();
    }

    public void insertConvenio(Convenio convenio){

        String sql = "INSERT INTO convenio (cadastrado,nome,valor) VALUES(now(),?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, convenio.getNome());
            preparedStatement.setBigDecimal(2, convenio.getValor());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                convenio.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Convenio> findAllConvenio(){
        String sql = "SELECT * FROM convenio";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Convenio> listaDeConvenios = new ArrayList<>();

            while (resultSet.next()){
                Convenio convenio = new Convenio();

                convenio.setId(resultSet.getLong("id"));
                convenio.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    convenio.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    convenio.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                convenio.setNome(resultSet.getString("nome"));
                convenio.setValor(resultSet.getBigDecimal("valor"));

                listaDeConvenios.add(convenio);
            }

            return listaDeConvenios;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Convenio findByIdConvenio(Long convenio_id){

        String sql = "SELECT * FROM convenio WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, convenio_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Convenio convenio = new Convenio();

                convenio.setId(resultSet.getLong("id"));
                convenio.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    convenio.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    convenio.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                convenio.setNome(resultSet.getString("nome"));
                convenio.setValor(resultSet.getBigDecimal("valor"));

                return convenio;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateConvenio(Convenio convenio){

        String sql = "UPDATE convenio SET atualizado = now(),nome = ?,valor = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,convenio.getNome());
            preparedStatement.setBigDecimal(2,convenio.getValor());
            preparedStatement.setLong(3, convenio.getId());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disableConvenio(Convenio convenio){

        String sql = "UPDATE convenio SET excluido = now() WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, convenio.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
