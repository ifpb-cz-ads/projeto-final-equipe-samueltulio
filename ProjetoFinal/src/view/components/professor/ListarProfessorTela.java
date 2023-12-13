package view.components.professor;

import daoSQL.ProfessorDao;
import model.Professor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
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
        atualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowCount = tableModel.getRowCount();

                for (int i = 0; i < rowCount; i++) {
                    String email = (String) tableModel.getValueAt(i, 0);
                    String nome = (String) tableModel.getValueAt(i, 1);
                    String cpf = (String) tableModel.getValueAt(i, 2);
                    int matricula = (int) tableModel.getValueAt(i, 3);
                    LocalDate dataNascimento = (LocalDate) tableModel.getValueAt(i, 4);
                    double salario = Double.parseDouble(tableModel.getValueAt(i, 5).toString());

                    Professor professor = new Professor(email, nome, cpf, matricula, dataNascimento, salario);

                    // Atualiza o professor no banco de dados
                    try {
                        pDao.updateProfessor(professor);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + ex.getMessage());
                    }
                }
                try {
                    pDao.connection.setAutoCommit(false);
                    pDao.connection.commit();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                // Recarrega os dados da tabela após a atualização
                try {
                    listProfessor = pDao.listProfessor();
                    tableModel.setRowCount(0); // Limpa a tabela
                    for (Professor professor : listProfessor) {
                        tableModel.addRow(new Object[]{professor.getEmail(), professor.getNome(), professor.getCpf(),
                                professor.getMatricula(), professor.getDataNascimento(), professor.getSalario()});
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + ex.getMessage());
                }
            }
        });

        JScrollPane scroll = new JScrollPane(tableProfessor);
        tablePane.add(scroll, BorderLayout.CENTER);
        panel.add(tablePane, BorderLayout.CENTER);
        panel.add(atualizar, BorderLayout.SOUTH);

        // Adiciona o JScrollPane ao JPanel
        add(panel, BorderLayout.CENTER);
    }

}
