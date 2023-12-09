package daoSQL;

import database.ConFactory;
import model.Aluno;
import model.Boletim;
import model.Professor;
import org.checkerframework.checker.units.qual.C;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao {
    private Connection connection;

    public AlunoDao() throws SQLException, ClassNotFoundException {
        connection = new ConFactory().getConnection();
    }

    public boolean addAluno(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, aluno.getEmail());
        statement.setString(2, aluno.getNome());
        statement.setString(3, aluno.getCpf());
        statement.setInt(4, aluno.getMatricula());
        java.sql.Date dataNascimentoSql = java.sql.Date.valueOf(aluno.getDataNascimento());
        statement.setDate(5, dataNascimentoSql);

        return statement.executeUpdate()>0;
    }

    public boolean deleteAluno(int matricula) throws SQLException {
        String sql = "DELETE FROM aluno WHERE matricula = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, matricula);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        }
    }

    public Aluno searchAluno(int matricula) throws SQLException {
        String sql = "SELECT * FROM aluno WHERE matricula = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, matricula);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Aluno aluno = new Aluno(resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4), resultSet.getDate(5).toLocalDate());
            return aluno;
        } else return null;

    }

    public List<Aluno> listAluno() throws SQLException{
        String sql = "SELECT * FROM aluno";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        List<Aluno> alunos = new ArrayList<>();

        while(resultSet.next()) {
            String email = resultSet.getString("email");
            String nome = resultSet.getString("nome");
            String cpf = resultSet.getString("cpf");
            int matricula = resultSet.getInt("matricula");
            LocalDate data = resultSet.getDate("datanascimento").toLocalDate();
            alunos.add(new Aluno(email, nome, cpf, matricula, data));
        }

        return alunos;
    }

    public boolean matricularDisciplina(int matriculaAluno, int idDisciplina, double nota) throws SQLException, ClassNotFoundException {
        DisciplinaDao daoD = new DisciplinaDao();
        String sql = "INSERT INTO disciplinaAluno VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, matriculaAluno);
        statement.setInt(2, idDisciplina);
        statement.setDouble(3, nota);
        if (daoD.searchDisciplina(idDisciplina) != null) {
            return statement.executeUpdate()>0;
        } else return false;
    }

    public List<Boletim> boletimAluno(int matricula) throws SQLException {
        String sql = "SELECT D.nome, D.iddisciplina, DA.nota\n" +
                "FROM (aluno A INNER JOIN disciplinaaluno DA ON A.matricula = DA.matriculaaluno) " +
                "INNER JOIN disciplina D ON DA.iddisciplina = d.iddisciplina\n" +
                "WHERE A.matricula = ?";


        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, matricula);
        List<Boletim> boletim = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
            String nome = resultSet.getString("nome");
            int idDisciplina = resultSet.getInt("iddisciplina");
            double nota = resultSet.getDouble("nota");
            boletim.add(new Boletim(nome, idDisciplina, nota));
        }
        return boletim;
    }
}
