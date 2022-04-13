package br.com.agenda.Dao;

import br.com.agenda.Factory.ConnectionFactory;
import br.com.agenda.Model.Agenda;
import br.com.agenda.Model.Medico;
import br.com.agenda.Model.Paciente;
import br.com.agenda.Model.StatusAgenda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDao {

    private static Connection connection;

    public AgendaDao() throws SQLException {
        this.connection = ConnectionFactory.getConexao();
    }

    public void insertAgendamento(Agenda agenda){

        String sql = "INSERT INTO agenda (cadastrado,id_paciente,id_medico,status_agendamento,data_agendamento,encaixe)" +
                "VALUES(now(),?,?,?,?,?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1,agenda.getPaciente().getId());
            preparedStatement.setLong(2, agenda.getMedico().getId());
            preparedStatement.setString(3, agenda.getStatusAgendamento().valor);
            preparedStatement.setTimestamp(4, Timestamp.valueOf(agenda.getDataAgendamento()));
            preparedStatement.setBoolean(5, agenda.getEncaixe());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                agenda.setId(resultSet.getLong(1));
            }

            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Agenda> findAllAgendamento(){

        String sql = "SELECT * FROM agenda";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Agenda> listaDeAgendas = new ArrayList<>();

            while (resultSet.next()){
                Agenda agenda = new Agenda();

                agenda.setId(resultSet.getLong("id"));
                agenda.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    agenda.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    agenda.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                PacienteDao pacienteDao = new PacienteDao();
                Paciente paciente = pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente"));
                agenda.setPaciente(paciente);

                MedicoDao medicoDao = new MedicoDao();
                Medico medico = medicoDao.findByIdMedico(resultSet.getLong("id_medico"));
                agenda.setMedico(medico);

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

                agenda.setDataAgendamento(resultSet.getTimestamp("data_agendamento").toLocalDateTime());
                agenda.setEncaixe(resultSet.getBoolean("encaixe"));

                listaDeAgendas.add(agenda);
            }

            return listaDeAgendas;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Agenda findByIdAgendamento(Long agenda_id){

        String sql = "SELECT * FROM agenda WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, agenda_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Agenda agenda = new Agenda();

                agenda.setId(resultSet.getLong("id"));
                agenda.setCadastro(resultSet.getTimestamp("cadastrado").toLocalDateTime());
                if(resultSet.getTimestamp("atualizado") != null ||
                        resultSet.getTimestamp("excluido") != null){
                    agenda.setAtualizado(resultSet.getTimestamp("atualizado").toLocalDateTime());
                    agenda.setExcluido(resultSet.getTimestamp("excluido").toLocalDateTime());
                }
                PacienteDao pacienteDao = new PacienteDao();
                Paciente paciente = pacienteDao.findByIdPaciente(resultSet.getLong("id_paciente"));
                agenda.setPaciente(paciente);

                MedicoDao medicoDao = new MedicoDao();
                Medico medico = medicoDao.findByIdMedico(resultSet.getLong("id_medico"));
                agenda.setMedico(medico);

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

                agenda.setDataAgendamento(resultSet.getTimestamp("data_agendamento").toLocalDateTime());
                agenda.setEncaixe(resultSet.getBoolean("encaixe"));

                return agenda;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateAgendamento(Agenda agenda){

        String sql = "UPDATE agenda SET atualizado = now(),id_paciente = ?,id_medico = ?," +
                "status_agendamento = ?,data_agendamento = ?,encaixe = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,agenda.getPaciente().getId());
            preparedStatement.setLong(2,agenda.getMedico().getId());
            preparedStatement.setString(3,agenda.getStatusAgendamento().valor);
            preparedStatement.setTimestamp(4,Timestamp.valueOf(agenda.getDataAgendamento()));
            preparedStatement.setBoolean(5,agenda.getEncaixe());
            preparedStatement.setLong(6, agenda.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void disableAgendamento(Agenda agenda){

        String sql = "UPDATE agenda SET excluido = now() WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, agenda.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
