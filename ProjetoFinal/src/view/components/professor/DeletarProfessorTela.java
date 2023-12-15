package view.components.professor;

import daoSQL.ProfessorDao;
import model.Professor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class DeletarProfessorTela extends JPanel {
    ProfessorDao pDao;
    List<Professor> listProfessor;
    String[] colNames = {"Email", "Nome", "CPF", "Matricula", "Data de nascimento", "Salário"};

    public DeletarProfessorTela() throws SQLException, ClassNotFoundException {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(6, 1));

        Color backgroundColor = Color.decode("#FBF7F4");
        panel.setBackground(backgroundColor);
        form.setBackground(backgroundColor);

        pDao = new ProfessorDao();
        listProfessor = pDao.listProfessor();

        JLabel matriculaLbl = new JLabel("Informe a matricula do professor");
        JTextField matriculaTxt = new JTextField();

        JButton pesquisar = new JButton("Pesquisar");
        Color buttonColor = Color.decode("#E8998D");
        pesquisar.setBackground(buttonColor);
        pesquisar.setForeground(Color.WHITE);

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
        JTable tableProfessor = new JTable(tableModel);

        pesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tableModel.setRowCount(0);
                    int mat = Integer.parseInt(matriculaTxt.getText());
                    Professor professor = pDao.searchProfessor(mat);
                    tableModel.addRow(new Object[]{professor.getEmail(), professor.getNome(), professor.getCpf(),
                            professor.getMatricula(), professor.getDataNascimento(), professor.getSalario()});
                } catch (NumberFormatException ex) {
                    // Tratamento para entrada inválida de matrícula
                    JOptionPane.showMessageDialog(null, "Professor não encontrado.");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton apagarProfessor = new JButton("Apagar");
        apagarProfessor.setBackground(buttonColor);
        apagarProfessor.setForeground(Color.WHITE);

        apagarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int mat = Integer.parseInt(matriculaTxt.getText());
                    if(pDao.deleteProfessor(mat)) {
                        JOptionPane.showMessageDialog(null, "Deletado com sucesso.");
                        tableModel.setRowCount(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao deletar");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Insira novamente a matricula.");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        form.add(matriculaLbl);
        form.add(matriculaTxt);
        form.add(pesquisar);
        form.add(tableProfessor);
        form.add(apagarProfessor);

        Font font = new Font("Arial", Font.PLAIN, 14);
        matriculaTxt.setFont(font);
        matriculaLbl.setFont(font);
        pesquisar.setFont(font);
        tableProfessor.setFont(font);
        apagarProfessor.setFont(font);

        int borderRadius = 15; // Ajuste conforme necessário
        pesquisar.setBorder(BorderFactory.createEmptyBorder(10, borderRadius, 10, borderRadius));
        apagarProfessor.setBorder(BorderFactory.createEmptyBorder(10, borderRadius, 10, borderRadius));

        int formWidth = 500; // ajuste conforme necessário
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