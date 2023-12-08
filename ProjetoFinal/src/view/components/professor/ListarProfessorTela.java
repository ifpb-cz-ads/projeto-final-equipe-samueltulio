package view.components.professor;

import daoSQL.ProfessorDao;
import model.Professor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ListarProfessorTela extends JPanel {

    String[] colNames = {"Email", "Nome", "CPF", "Matricula", "Data de nascimento", "Salário"};
    ProfessorDao pDao;
    List<Professor> listProfessor;

    public ListarProfessorTela() throws SQLException, ClassNotFoundException {
        pDao = new ProfessorDao();
        listProfessor = pDao.listProfessor();

        setLayout(new GridLayout());

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
        JTable tableProfessor = new JTable(tableModel);

        // Adiciona os dados da lista à tabela
        for (Professor professor : listProfessor) {
            tableModel.addRow(new Object[]{professor.getEmail(), professor.getNome(), professor.getCpf(),
                    professor.getMatricula(), professor.getDataNascimento(), professor.getSalario()});
        }

        JScrollPane scroll = new JScrollPane(tableProfessor);

        // Adiciona o JScrollPane ao JPanel
        add(scroll, BorderLayout.CENTER);
    }

}
