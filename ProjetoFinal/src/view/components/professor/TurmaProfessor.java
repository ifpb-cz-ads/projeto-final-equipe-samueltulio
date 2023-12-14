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

        JButton aliciar = new JButton("Associar com turma");
        form.add(aliciar);

        pesquisarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pDao = new ProfessorDao();
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
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        pesquisarTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tDao = new TurmaDao();
                    tableModelTurma.setRowCount(0);
                    int mat = Integer.parseInt(txtTurma.getText());
                    Turma turma = tDao.searchTurma(mat);
                    tableModelTurma.addRow(new Object[]{turma.getIdTurma(), turma.getSerie(), turma.getAnoLetivo()});
                } catch (NumberFormatException ex) {
                    // Tratamento para entrada inválida de matrícula
                    JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        aliciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int matProfessor = Integer.parseInt(txtProfessor.getText());
                int idTurma = Integer.parseInt(txtTurma.getText());
                try {
                    pDao = new ProfessorDao();
                    if(pDao.turmaProfessor(matProfessor, idTurma)) {
                        JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        panel.add(form, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);
    }

}
