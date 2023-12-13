package daoSQL;

import database.ConFactory;
import model.Aluno;
import model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDao {
    public Connection connection;

    public TurmaDao() throws SQLException, ClassNotFoundException {
        connection = new ConFactory().getConnection();
    }

    public boolean addTurma(Turma turma) throws SQLException {
        String sql = "INSERT INTO turma VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, turma.getIdTurma());
        statement.setString(2, turma.getSerie());
        statement.setInt(3, turma.getAnoLetivo());

        return statement.executeUpdate()>0;
    }

    public boolean deleteTurma(int idTurma) throws SQLException {
        String sql = "DELETE FROM turma WHERE idTurma = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idTurma);

            int rowsAfected = statement.executeUpdate();

            return rowsAfected > 0;
        }
    }

    public Turma searchTurma(int idTurma) throws SQLException {
        String sql = "SELECT * FROM turma WHERE idTurma = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idTurma);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Turma turma = new Turma(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            return turma;
        } else return null;

    }

    public List<Turma> listTurma() throws SQLException {
        String sql = "SELECT * FROM turma";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        List<Turma> turmas = new ArrayList<>();
        while(resultSet.next()) {
            int idTurma = resultSet.getInt("idturma");
            String serie = resultSet.getString("serie");
            int anoLetivo = resultSet.getInt("anoletivo");
            turmas.add(new Turma(idTurma, serie, anoLetivo));
        }

        return turmas;
    }

    public List<Aluno> alunosTurma(int idTurma) throws SQLException {
        String sql = "SELECT A.nome, A.matricula\n" +
                "FROM (aluno A INNER JOIN alunosporturma AT on A.matricula = AT.matriculaaluno)\n" +
                "\tINNER JOIN turma T on AT.idturma = T.idturma\n" +
                "WHERE T.idturma = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idTurma);
        List<Aluno> alunos = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
            String nome = resultSet.getString("nome");
            int matricula = resultSet.getInt("matricula");
            alunos.add(new Aluno(nome, matricula));
        }
        return alunos;
    }

    public boolean addAlunoTurma(int matAluno, int idDisciplina) throws SQLException {
        String sql = "INSERT INTO alunosporturma VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, matAluno);
        statement.setInt(2, idDisciplina);

        int rowsAfected = statement.executeUpdate();
        return rowsAfected > 0;
    }

    public boolean updateTurma(Turma turma) throws SQLException {
        String sql = "UPDATE turma SET idturma=?, serie=?, anoletivo=? WHERE idturma=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, turma.getIdTurma());
        statement.setString(2, turma.getSerie());
        statement.setInt(3, turma.getAnoLetivo());
        statement.setInt(4, turma.getIdTurma());

        return statement.executeUpdate()>0;
    }
}
