package view.components.turma;

import daoSQL.TurmaDao;
import model.Aluno;
import model.Turma;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class AlunosPorTurmaTela extends JPanel {
    private String[] colNames = {"Nome", "Matrícula"};
    private TurmaDao tDao;
    private JComboBox<String> turmaComboBox;
    private DefaultTableModel tableModel;
    private JTable tableAluno;

    public AlunosPorTurmaTela() throws SQLException, ClassNotFoundException {
        tDao = new TurmaDao();
        java.util.List<Turma> turmas = tDao.listTurma();

        setLayout(new BorderLayout());

        turmaComboBox = new JComboBox<>();
        turmaComboBox.addItem("Escolha uma turma");
        for(Turma turma : turmas) {
            turmaComboBox.addItem(turma.getSerie());
        }

        this.tableModel = new DefaultTableModel(colNames, 0);
        tableAluno = new JTable(this.tableModel);
        JScrollPane scrollPane = new JScrollPane(tableAluno);

        turmaComboBox.addActionListener(e -> {
            try {
                java.util.List<Aluno> listAluno = tDao.alunosTurma(turmaComboBox.getSelectedIndex());
                updateTableData(listAluno);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        if (turmaComboBox.getItemCount() > 0) {
            turmaComboBox.setSelectedIndex(0);
        }

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(turmaComboBox, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Adiciona o JPanel com JComboBox e JTable ao JPanel principal
        add(panel, BorderLayout.CENTER);
    }

    private void updateTableData(java.util.List<Aluno> listAluno) {
        tableModel.setRowCount(0);
        for (Aluno aluno : listAluno) {
            tableModel.addRow(new Object[]{aluno.getNome(), aluno.getMatricula()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                JFrame frame = new JFrame("Teste AlunosPorTurmaTela");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);

                AlunosPorTurmaTela alunosPorTurmaTela = new AlunosPorTurmaTela();
                frame.add(alunosPorTurmaTela);

                frame.setVisible(true);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
