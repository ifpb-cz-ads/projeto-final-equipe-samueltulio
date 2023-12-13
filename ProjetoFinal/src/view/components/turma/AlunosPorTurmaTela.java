package view.components.turma;

import daoSQL.TurmaDao;
import model.Aluno;
import model.Turma;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class AlunosPorTurmaTela extends JPanel {
    String[] colNames = {"Nome", "Matrícula"};
    TurmaDao tDao;
    java.util.List<Aluno> listAluno;

    JComboBox<String> turmaComboBox;
    DefaultTableModel tableModel;

    public AlunosPorTurmaTela() throws SQLException, ClassNotFoundException {
        tDao = new TurmaDao();
        java.util.List<Turma> turmas = tDao.listTurma();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel tablePane = new JPanel();
        tablePane.setLayout(new BorderLayout());

        turmaComboBox = new JComboBox<>();
        turmaComboBox.addItem("Escolha uma turma");
        for(Turma turma : turmas) {
            turmaComboBox.addItem(turma.getSerie());
        }

        this.tableModel = new DefaultTableModel(colNames, 0);
        JTable tableAluno = new JTable(this.tableModel);

        turmaComboBox.addActionListener(e -> {
            try {
                listAluno = tDao.alunosTurma(turmaComboBox.getSelectedIndex());
                updateTableData();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        if (turmaComboBox.getItemCount() > 0) {
            turmaComboBox.setSelectedIndex(0);
        }

        JScrollPane scroll = new JScrollPane(tableAluno);
        tablePane.add(scroll, BorderLayout.CENTER);
        panel.add(turmaComboBox, BorderLayout.NORTH);
        panel.add(tablePane, BorderLayout.CENTER);

        // Adiciona o JScrollPane ao JPanel
        add(panel, BorderLayout.CENTER);
    }

    private void updateTableData() {
            tableModel.setRowCount(0);
            for (Aluno aluno : listAluno) {
                tableModel.addRow(new Object[]{aluno.getNome(), aluno.getMatricula()});
            }
    }

}
