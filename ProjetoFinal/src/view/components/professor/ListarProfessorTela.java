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

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel tablePane = new JPanel();
        tablePane.setLayout(new BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
        JTable tableProfessor = new JTable(tableModel);

        // Adiciona os dados da lista à tabela
        for (Professor professor : listProfessor) {
            tableModel.addRow(new Object[]{professor.getEmail(), professor.getNome(), professor.getCpf(),
                    professor.getMatricula(), professor.getDataNascimento(), professor.getSalario()});
        }

        JButton atualizar = new JButton("Atualizar");

        JScrollPane scroll = new JScrollPane(tableProfessor);
        tablePane.add(scroll, BorderLayout.CENTER);
        panel.add(tablePane, BorderLayout.CENTER);
        panel.add(atualizar, BorderLayout.SOUTH);

        // Adiciona o JScrollPane ao JPanel
        add(panel, BorderLayout.CENTER);
    }

}
