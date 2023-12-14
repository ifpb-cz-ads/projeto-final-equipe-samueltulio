package view.components.professor;

import daoSQL.ProfessorDao;
import daoSQL.TurmaDao;
import model.Professor;
import model.Turma;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TurmaProfessor extends JPanel {
    ProfessorDao pDao;
    TurmaDao  tDao;
    String[] colNamesProfessor = {"Email", "Nome", "CPF", "Matricula", "Data de nascimento", "Salário"};
    String[] colNamesTurma = {"Identificador", "Série", "Ano Letivo"};

    public TurmaProfessor() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(8, 2));

        JLabel jlbProfessor = new JLabel("Nome:");
        JTextField txtProfessor = new JTextField();
        form.add(jlbProfessor);
        form.add(txtProfessor);

        JButton pesquisarProfessor = new JButton("Pesquisar");
        form.add(pesquisarProfessor);

        DefaultTableModel tableModelProfessor = new DefaultTableModel(colNamesProfessor, 0);
        JTable tableProfessor = new JTable(tableModelProfessor);
        form.add(tableProfessor);

        JLabel jlbTurma = new JLabel("Turma:");
        JTextField txtTurma = new JTextField();
        form.add(jlbTurma);
        form.add(txtTurma);

        JButton pesquisarTurma = new JButton("Pesquisar");
        form.add(pesquisarTurma);

        DefaultTableModel tableModelTurma = new DefaultTableModel(colNamesTurma, 0);
        JTable tableTurma = new JTable(tableModelTurma);
        form.add(tableTurma);

        pesquisarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tableModelProfessor.setRowCount(0);
                    int mat = Integer.parseInt(txtProfessor.getText());
                    Professor professor = pDao.searchProfessor(mat);
                    tableModelProfessor.addRow(new Object[]{professor.getEmail(), professor.getNome(), professor.getCpf(),
                            professor.getMatricula(), professor.getDataNascimento(), professor.getSalario()});
                } catch (NumberFormatException ex) {
                    // Tratamento para entrada inválida de matrícula
                    JOptionPane.showMessageDialog(null, "Professor não encontrado.");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

//        pesquisarProfessor.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    tableModelProfessor.setRowCount(0);
//                    int mat = Integer.parseInt(txtProfessor.getText());
//                    Professor professor = pDao.searchProfessor(mat);
//                    tableModelProfessor.addRow(new Object[]{professor.getEmail(), professor.getNome(), professor.getCpf(),
//                            professor.getMatricula(), professor.getDataNascimento(), professor.getSalario()});
//                } catch (NumberFormatException ex) {
//                    // Tratamento para entrada inválida de matrícula
//                    JOptionPane.showMessageDialog(null, "Professor não encontrado.");
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });

        pesquisarTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tableModelTurma.setRowCount(0);
                    int mat = Integer.parseInt(txtTurma.getText());
                    Turma turma = tDao.searchTurma(mat);
                    tableModelTurma.addRow(new Object[]{turma.getIdTurma(), turma.getSerie(), turma.getAnoLetivo()});
                } catch (NumberFormatException ex) {
                    // Tratamento para entrada inválida de matrícula
                    JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        panel.add(form, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);
    }

}
