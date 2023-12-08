package daoSQL;

import database.ConFactory;
import model.Professor;
import model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

public class TurmaDao {
    private Connection connection;

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
}
