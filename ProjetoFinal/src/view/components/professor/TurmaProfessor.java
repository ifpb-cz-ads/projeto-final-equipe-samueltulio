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
        form.setLayout(new GridLayout(6, 1));

        Color backgroundColor = Color.decode("#FBF7F4");
        panel.setBackground(backgroundColor);
        form.setBackground(backgroundColor);

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

    JButton aliciar = new JButton("Associar professor");
    aliciar.setBackground(backgroundColor);
    aliciar.setForeground(Color.WHITE);
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
                try {
                    tDao = new TurmaDao();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                int idTurma = Integer.parseInt(txtTurma.getText());

                try {
                    pDao = new ProfessorDao();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                tableModelProfessor.setRowCount(0);
                int matprofessor = Integer.parseInt(txtProfessor.getText());

                try {
                    if(pDao.turmaProfessor(matprofessor, idTurma)) {
                        JOptionPane.showMessageDialog(null, "Este professor agora dá aula nessa turma");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao aliciar professor e turma.");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Font font = new Font("Arial", Font.PLAIN, 14);
        jlbTurma.setFont(font);
        txtTurma.setFont(font);
        jlbProfessor.setFont(font);
        txtProfessor.setFont(font);
        pesquisarTurma.setFont(font);
        pesquisarProfessor.setFont(font);
        aliciar.setFont(font);

        Color buttonColor = Color.decode("#E8998D");
        pesquisarTurma.setBackground(buttonColor);
        pesquisarTurma.setForeground(Color.WHITE);
        pesquisarProfessor.setBackground(buttonColor);
        pesquisarProfessor.setForeground(Color.WHITE);
        aliciar.setBackground(buttonColor);
        aliciar.setForeground(Color.WHITE);

        int borderRadius = 15; // Ajuste conforme necessário
        pesquisarProfessor.setBorder(BorderFactory.createEmptyBorder(10, borderRadius, 10, borderRadius));
        pesquisarTurma.setBorder(BorderFactory.createEmptyBorder(10, borderRadius, 10, borderRadius));

        int formWidth = 300; // ajuste conforme necessário
        int formHeight = 300; // ajuste conforme necessário
        form.setPreferredSize(new Dimension(formWidth, formHeight));
        form.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), // margens internas
                BorderFactory.createLineBorder(Color.BLACK) // borda preta
        ));

        panel.add(form, BorderLayout.CENTER);
        setBackground(backgroundColor);
        add(panel, BorderLayout.CENTER);
    }

}