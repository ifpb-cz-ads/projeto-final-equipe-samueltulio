package daoSQL;

import database.ConFactory;
import model.Disciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao {
    private Connection connection;

    public DisciplinaDao() throws SQLException, ClassNotFoundException {
        connection = new ConFactory().getConnection();
    }

    public boolean addDisciplina(Disciplina disciplina) throws SQLException {
        String sql = "INSERT INTO disciplina VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, disciplina.getIdDisciplina());
        statement.setString(2, disciplina.getNome());

        return statement.executeUpdate()>0;
    }

    public boolean deleteDisciplina(int idDisciplina) throws SQLException {
        String sql = "DELETE FROM disciplina WHERE idDisciplina = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idDisciplina);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        }
    }

    public Disciplina searchDisciplina(int idDisciplina) throws SQLException {
        String sql = "SELECT * FROM disciplina WHERE idDisciplina = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idDisciplina);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            Disciplina disciplina = new Disciplina(resultSet.getInt("idDisciplina"), resultSet.getString("nome"));
            return disciplina;
        } else return null;

    }

    public List<Disciplina> listDisciplina() throws SQLException{
        String sql = "SELECT * FROM disciplina";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        List<Disciplina> disciplinas = new ArrayList<>();

        while(resultSet.next()) {
            int idDisciplina = resultSet.getInt("idDisciplina");
            String nome = resultSet.getString("nome");
            disciplinas.add(new Disciplina(idDisciplina, nome));
        }

        return disciplinas;
    }
}
