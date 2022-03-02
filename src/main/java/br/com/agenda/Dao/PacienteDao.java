package br.com.agenda.Dao;

import br.com.agenda.Factory.ConnectionFactory;
import br.com.agenda.Model.Convenio;
import br.com.agenda.Model.Paciente;
import br.com.agenda.Model.Sexo;
import br.com.agenda.Model.TipoAtendimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {

    private static Connection connection;

    public PacienteDao() throws SQLException {
        this.connection = ConnectionFactory.getConexao();
    }

    public void insertPaciente(Paciente paciente){

        String sql = "INSERT INTO paciente(cadastrado,nome,email,login,senha,cpf,rg,cep,telefone,nacionalidade,sexo," +
                "tipo_atendimento,id_convenio,numero_cartao_convenio,data_vencimento)" +
                "VALUES(now(),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getEmail());
            preparedStatement.setString(3, paciente.getLogin());
            preparedStatement.setString(4, paciente.getSenha());
            preparedStatement.setString(5, paciente.getCpf());
            preparedStatement.setString(6, paciente.getRg());
            preparedStatement.setString(7, paciente.getCep());
            preparedStatement.setString(8, paciente.getTelefone());
            preparedStatement.setString(9, paciente.getNacionalidade());
            preparedStatement.setString(10, paciente.getSexo().valor);
            preparedStatement.setString(11, paciente.getTipoAtendimento().valor);
            preparedStatement.setLong(12, paciente.getConvenio().getId());
            preparedStatement.setString(13, paciente.getNumeroCartaoConvenio());
            preparedStatement.setTimestamp(14, Timestamp.valueOf(paciente.getDataVencimento()));
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                paciente.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Paciente> findAllPaciente(){

        String sql = "SELECT * FROM paciente";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Paciente> listaDePacientes = new ArrayList<>();

            while (resultSet.next()){
                Paciente paciente = new Paciente();

                paciente.setId(resultSet.getLong("id"));
                paciente.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    paciente.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    paciente.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                paciente.setNome(resultSet.getString("nome"));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setLogin(resultSet.getString("login"));
                paciente.setSenha(resultSet.getString("senha"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setRg(resultSet.getString("rg"));
                paciente.setCep(resultSet.getString("cep"));
                paciente.setTelefone(resultSet.getString("telefone"));
                paciente.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        paciente.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        paciente.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        paciente.setSexo(Sexo.outros);
                        break;
                }
                switch (resultSet.getString("tipo_atendimento")){
                    case "Particluar":
                        paciente.setTipoAtendimento(TipoAtendimento.particular);
                        break;
                    case "Convenio":
                        paciente.setTipoAtendimento(TipoAtendimento.convenio);
                        break;
                }
                ConvenioDao convenioDao = new ConvenioDao();
                Convenio convenio = convenioDao.findByIdConvenio(resultSet.getLong("id_convenio"));
                paciente.setConvenio(convenio);
                paciente.setNumeroCartaoConvenio(resultSet.getString("numero_cartao_convenio"));
                paciente.setDataVencimento(resultSet.getTimestamp("data_vencimento").toLocalDateTime());

                listaDePacientes.add(paciente);
            }

            return listaDePacientes;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Paciente findByIdPaciente(Long paciente_id){

        String sql = "SELECT * FROM paciente WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, paciente_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Paciente paciente = new Paciente();

                paciente.setId(resultSet.getLong("id"));
                paciente.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    paciente.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    paciente.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                paciente.setNome(resultSet.getString("nome"));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setLogin(resultSet.getString("login"));
                paciente.setSenha(resultSet.getString("senha"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setRg(resultSet.getString("rg"));
                paciente.setCep(resultSet.getString("cep"));
                paciente.setTelefone(resultSet.getString("telefone"));
                paciente.setNacionalidade(resultSet.getString("nacionalidade"));
                switch (resultSet.getString("sexo")){
                    case "Masculino":
                        paciente.setSexo(Sexo.masculino);
                        break;
                    case "Feminino":
                        paciente.setSexo(Sexo.feminino);
                        break;
                    case "Outros":
                        paciente.setSexo(Sexo.outros);
                        break;
                }
                switch (resultSet.getString("tipo_atendimento")){
                    case "Particular":
                        paciente.setTipoAtendimento(TipoAtendimento.particular);
                        break;
                    case "Convenio":
                        paciente.setTipoAtendimento(TipoAtendimento.convenio);
                        break;
                }
                ConvenioDao convenioDao = new ConvenioDao();
                Convenio convenio = convenioDao.findByIdConvenio(resultSet.getLong("id_convenio"));
                paciente.setConvenio(convenio);
                paciente.setNumeroCartaoConvenio(resultSet.getString("numero_cartao_convenio"));
                paciente.setDataVencimento(resultSet.getTimestamp("data_vencimento").toLocalDateTime());

                return paciente;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updatePaciente(Paciente paciente){

        String sql = "UPDATE paciente SET atualizado = now(),nome = ?,email = ?,login = ?,senha = ?," +
                "cpf = ?,rg = ?,cep = ?,telefone = ?,nacionalidade = ?,sexo = ?,tipo_atendimento = ?," +
                "id_convenio = ?,numero_cartao_convenio = ?, data_vencimento = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,paciente.getNome());
            preparedStatement.setString(2,paciente.getEmail());
            preparedStatement.setString(3, paciente.getLogin());
            preparedStatement.setString(4,paciente.getSenha());
            preparedStatement.setString(5,paciente.getCpf());
            preparedStatement.setString(6,paciente.getRg());
            preparedStatement.setString(7,paciente.getCep());
            preparedStatement.setString(8,paciente.getTelefone());
            preparedStatement.setString(9,paciente.getNacionalidade());
            preparedStatement.setString(10,paciente.getSexo().valor);
            preparedStatement.setString(11,paciente.getTipoAtendimento().valor);
            preparedStatement.setLong(12,paciente.getConvenio().getId());
            preparedStatement.setString(13,paciente.getNumeroCartaoConvenio());
            preparedStatement.setTimestamp(14, Timestamp.valueOf(paciente.getDataVencimento()));
            preparedStatement.setLong(15, paciente.getId());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disablePaciente(Paciente paciente){

        String sql = "UPDATE paciente SET excluido = now() WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, paciente.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
