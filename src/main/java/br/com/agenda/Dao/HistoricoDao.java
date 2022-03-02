package br.com.agenda.Dao;

import br.com.agenda.Factory.ConnectionFactory;
import br.com.agenda.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDao {

    private static Connection connection;

    public HistoricoDao() throws SQLException {
        this.connection = ConnectionFactory.getConexao();
    }

    public void insertHistorico(Historico historico){

        String sql = "INSERT INTO historico (cadastrado,id_historico,observacao,status_historicomento,id_paciente," +
                "id_secretaria,data) VALUES(now(),?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, historico.getAgenda().getId());
            preparedStatement.setString(2, historico.getObservacao());
            preparedStatement.setString(3, historico.getStatusAgenda().valor);
            preparedStatement.setLong(4, historico.getPaciente().getId());
            preparedStatement.setLong(5, historico.getSecretaria().getId());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(historico.getData()));
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                historico.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Historico> findAllHistorico(){

        String sql = "SELECT * FROM historico";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Historico> listaDeHistoricos = new ArrayList<>();

            while (resultSet.next()){
                Historico historico = new Historico();

                historico.setId(resultSet.getLong("id"));
                historico.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    historico.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    historico.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }

                AgendaDao agendaDao = new AgendaDao();
                Agenda agenda = agendaDao.findByIdAgendamento(resultSet.getLong("id_agenda"));
                historico.setAgenda(agenda);

                historico.setObservacao(resultSet.getString("observacao"));

                switch (resultSet.getString("status_agendamento")){
                    case "Pendente":
                        agenda.setStatusAgenda(StatusAgenda.pendente);
                        break;
                    case "Aprovado":
                        agenda.setStatusAgenda(StatusAgenda.aprovado);
                        break;
                    case "Cancelado":
                        agenda.setStatusAgenda(StatusAgenda.cancelado);
                        break;
                    case "Compareceu":
                        agenda.setStatusAgenda(StatusAgenda.compareceu);
                        break;
                    case "Não Compareceu":
                        agenda.setStatusAgenda(StatusAgenda.naoCompareceu);
                        break;
                    case "Rejeitado":
                        agenda.setStatusAgenda(StatusAgenda.rejeitado);
                        break;
                }

                PacienteDao pacienteDao = new PacienteDao();
                Paciente paciente = pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente"));
                historico.setPaciente(paciente);

                SecretariaDao secretariaDao = new SecretariaDao();
                Secretaria secretaria = secretariaDao.findByIdSecretaria(resultSet.getLong("id_secretaria"));
                historico.setSecretaria(secretaria);

                historico.setData(resultSet.getTimestamp("data").toLocalDateTime());

                listaDeHistoricos.add(historico);
            }

            return listaDeHistoricos;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Historico findByIdHistorico(Long historico_id){

        String sql = "SELECT * FROM historico WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, historico_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Historico historico = new Historico();

                historico.setId(resultSet.getLong("id"));
                historico.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    historico.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    historico.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }

                AgendaDao agendaDao = new AgendaDao();
                Agenda agenda = agendaDao.findByIdAgendamento(resultSet.getLong("id_agenda"));
                historico.setAgenda(agenda);

                historico.setObservacao(resultSet.getString("observacao"));

                switch (resultSet.getString("status_agendamento")){
                    case "Pendente":
                        agenda.setStatusAgenda(StatusAgenda.pendente);
                        break;
                    case "Aprovado":
                        agenda.setStatusAgenda(StatusAgenda.aprovado);
                        break;
                    case "Cancelado":
                        agenda.setStatusAgenda(StatusAgenda.cancelado);
                        break;
                    case "Compareceu":
                        agenda.setStatusAgenda(StatusAgenda.compareceu);
                        break;
                    case "Não Compareceu":
                        agenda.setStatusAgenda(StatusAgenda.naoCompareceu);
                        break;
                    case "Rejeitado":
                        agenda.setStatusAgenda(StatusAgenda.rejeitado);
                        break;
                }

                PacienteDao pacienteDao = new PacienteDao();
                Paciente paciente = pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente"));
                historico.setPaciente(paciente);

                SecretariaDao secretariaDao = new SecretariaDao();
                Secretaria secretaria = secretariaDao.findByIdSecretaria(resultSet.getLong("id_secretaria"));
                historico.setSecretaria(secretaria);

                historico.setData(resultSet.getTimestamp("data").toLocalDateTime());

                return historico;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }


}
