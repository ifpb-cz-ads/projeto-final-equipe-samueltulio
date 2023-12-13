package daoSQL;

import database.ConFactory;
import model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDao {
    public Connection connection;

    public ProfessorDao() throws SQLException, ClassNotFoundException {
        connection = new ConFactory().getConnection();
    }

    public boolean addProfessor(Professor professor) throws SQLException {
        String sql = "INSERT INTO professor VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, professor.getEmail());
        statement.setString(2, professor.getNome());
        statement.setString(3, professor.getCpf());
        statement.setInt(4, professor.getMatricula());
        java.sql.Date dataNascimentoSql = java.sql.Date.valueOf(professor.getDataNascimento());
        statement.setDate(5, dataNascimentoSql);
        statement.setFloat(6, professor.getSalario());

        return statement.executeUpdate()>0;
    }

    public boolean deleteProfessor(int matricula) throws SQLException {
        String sql = "DELETE FROM professor WHERE matricula = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, matricula);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        }
    }

    public Professor searchProfessor(int matricula) throws SQLException {
        String sql = "SELECT * FROM professor WHERE matricula = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, matricula);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Professor professor = new Professor(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getDate(5).toLocalDate(),
                    resultSet.getDouble(6));
            return professor;
        } else return null;

    }

    public List<Professor> listProfessor() throws SQLException{
        String sql = "SELECT * FROM professor";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        List<Professor> professores = new ArrayList<>();

        while(resultSet.next()) {
            String email = resultSet.getString("email");
            String nome = resultSet.getString("nome");
            String cpf = resultSet.getString("cpf");
            int matricula = resultSet.getInt("matricula");
            LocalDate data = resultSet.getDate("datanascimento").toLocalDate();
            double salario = resultSet.getDouble("salario");
            professores.add(new Professor(email, nome, cpf, matricula, data, salario));
        }

        return professores;
    }

    public boolean disciplinaProfessor(int matriculaProfessor, int idDisciplina) throws SQLException {
        String sql = "INSERT INTO professordisciplina VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idDisciplina);
        statement.setInt(2, matriculaProfessor);

        return statement.executeUpdate()>0;
    }

    public boolean turmaProfessor(int matriculaprofessor, int idTurma) throws SQLException {
        String sql = "INSERT INTO professoresporturma VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, matriculaprofessor);
        statement.setInt(2, idTurma);

        return statement.executeUpdate()>0;
    }

    public boolean updateProfessor(Professor professor) throws SQLException{
        String sql = "UPDATE professor SET email=?, nome=?, cpf=?, dataNascimento=?, salario=? WHERE matricula=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, professor.getEmail());
        statement.setString(2, professor.getNome());
        statement.setString(3, professor.getCpf());
        statement.setDate(4, java.sql.Date.valueOf(professor.getDataNascimento()));
        statement.setDouble(5, professor.getSalario());
        statement.setInt(6, professor.getMatricula());

        return statement.executeUpdate()>0;
    }

}
