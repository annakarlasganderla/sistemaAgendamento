package br.com.agenda.Dao;

import br.com.agenda.Factory.ConnectionFactory;
import br.com.agenda.Model.Secretaria;
import br.com.agenda.Model.Sexo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SecretariaDao {

    private static Connection connection;

    public SecretariaDao() throws SQLException {
        this.connection = ConnectionFactory.getConexao();
    }


    public void insertSecretaria(Secretaria secretaria){

        String sql = "INSERT INTO secretaria (cadastrado,nome,email,login,senha,cpf,rg,cep,telefone,nacionalidade,sexo," +
                "salario,data_contratacao,pis) " +
                "VALUES(now(),?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, secretaria.getNome());
            preparedStatement.setString(2, secretaria.getEmail());
            preparedStatement.setString(3, secretaria.getLogin());
            preparedStatement.setString(4, secretaria.getSenha());
            preparedStatement.setString(5, secretaria.getCpf());
            preparedStatement.setString(6, secretaria.getRg());
            preparedStatement.setString(7, secretaria.getCep());
            preparedStatement.setString(8, secretaria.getTelefone());
            preparedStatement.setString(9, secretaria.getNacionalidade());
            preparedStatement.setString(10, secretaria.getSexo().valor);
            preparedStatement.setBigDecimal(11, secretaria.getSalario());
            preparedStatement.setTimestamp(12, Timestamp.valueOf(secretaria.getDataContratacao()));
            preparedStatement.setString(13, secretaria.getPis());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                secretaria.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Secretaria> findAllSecretaria(){

        String sql = "SELECT * FROM secretaria";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Secretaria> listaDeSecretarias = new ArrayList<>();

            while (resultSet.next()){
                Secretaria secretaria = new Secretaria();

                secretaria.setId(resultSet.getLong("id"));
                secretaria.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    secretaria.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    secretaria.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                secretaria.setNome(resultSet.getString("nome"));
                secretaria.setEmail(resultSet.getString("email"));
                secretaria.setLogin(resultSet.getString("login"));
                secretaria.setSenha(resultSet.getString("senha"));
                secretaria.setCpf(resultSet.getString("cpf"));
                secretaria.setRg(resultSet.getString("rg"));
                secretaria.setCep(resultSet.getString("cep"));
                secretaria.setTelefone(resultSet.getString("telefone"));
                secretaria.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        secretaria.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        secretaria.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        secretaria.setSexo(Sexo.outros);
                        break;
                }
                secretaria.setSalario(resultSet.getBigDecimal("salario"));
                secretaria.setDataContratacao(resultSet.getTimestamp("data_contratacao").toLocalDateTime());
                secretaria.setPis(resultSet.getString("pis"));

                listaDeSecretarias.add(secretaria);
            }

            return listaDeSecretarias;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Secretaria findByIdSecretaria(Long secretaria_id){

        String sql = "SELECT * FROM secretaria WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, secretaria_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Secretaria secretaria = new Secretaria();

                secretaria.setId(resultSet.getLong("id"));
                secretaria.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    secretaria.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    secretaria.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                secretaria.setNome(resultSet.getString("nome"));
                secretaria.setEmail(resultSet.getString("email"));
                secretaria.setLogin(resultSet.getString("login"));
                secretaria.setSenha(resultSet.getString("senha"));
                secretaria.setCpf(resultSet.getString("cpf"));
                secretaria.setRg(resultSet.getString("rg"));
                secretaria.setCep(resultSet.getString("cep"));
                secretaria.setTelefone(resultSet.getString("telefone"));
                secretaria.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        secretaria.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        secretaria.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        secretaria.setSexo(Sexo.outros);
                        break;
                }
                secretaria.setSalario(resultSet.getBigDecimal("salario"));
                secretaria.setDataContratacao(resultSet.getTimestamp("data_contratacao").toLocalDateTime());
                secretaria.setPis(resultSet.getString("pis"));

                return secretaria;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateSecretaria(Secretaria secretaria){

        String sql = "UPDATE secretaria SET atualizado = now(),nome = ?,email = ?,login = ?,senha = ?," +
                "cpf = ?,rg = ?,cep = ?,telefone = ?,nacionalidade = ?,sexo = ?,salario = ?,data_contratacao = ?," +
                "pis = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,secretaria.getNome());
            preparedStatement.setString(2,secretaria.getEmail());
            preparedStatement.setString(3, secretaria.getLogin());
            preparedStatement.setString(4,secretaria.getSenha());
            preparedStatement.setString(5,secretaria.getCpf());
            preparedStatement.setString(6,secretaria.getRg());
            preparedStatement.setString(7,secretaria.getCep());
            preparedStatement.setString(8,secretaria.getTelefone());
            preparedStatement.setString(9,secretaria.getNacionalidade());
            preparedStatement.setString(10,secretaria.getSexo().valor);
            preparedStatement.setBigDecimal(11,secretaria.getSalario());
            preparedStatement.setTimestamp(12, Timestamp.valueOf(secretaria.getDataContratacao()));
            preparedStatement.setString(13,secretaria.getPis());
            preparedStatement.setLong(14, secretaria.getId());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disableSecretaria(Secretaria secretaria){

        String sql = "UPDATE secretaria SET excluido = now() WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, secretaria.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }


}
