package view.components.aluno;

import daoSQL.AlunoDao;
import model.Aluno;
import model.Professor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ListarAlunoTela extends JPanel {
    AlunoDao aDao;
    List<Aluno> listAluno;
    String[] colNames = {"Email", "Nome", "CPF", "Matrícula", "Data de Nascimento"};
    public ListarAlunoTela() throws SQLException, ClassNotFoundException {
        aDao = new AlunoDao();
        listAluno = aDao.listAluno();

        Font font = new Font("Arial", Font.PLAIN, 14);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel tablePane = new JPanel();
        tablePane.setLayout(new BorderLayout());

        Color backgroundColor = Color.decode("#FBF7F4");
        panel.setBackground(backgroundColor);
        tablePane.setBackground(backgroundColor);

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
        JTable tableAluno = new JTable(tableModel);
        tableAluno.setBackground(backgroundColor);
        tableAluno.setFont(font);

        // Adiciona os dados da lista à tabela
        for (Aluno aluno : listAluno) {
            tableModel.addRow(new Object[]{aluno.getEmail(), aluno.getNome(), aluno.getCpf(),
                    aluno.getMatricula(), aluno.getDataNascimento()});
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

                    Aluno aluno = new Aluno(email, nome, cpf, matricula, dataNascimento);

                    // Atualiza o Aluno no banco de dados
                    try {
                        aDao.updateAluno(aluno);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + ex.getMessage());
                    }
                }

                try {
                    aDao.connection.setAutoCommit(false);
                    aDao.connection.commit();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    listAluno = aDao.listAluno();
                    tableModel.setRowCount(0); // Limpa a tabela
                    for (Aluno Aluno : listAluno) {
                        tableModel.addRow(new Object[]{Aluno.getEmail(), Aluno.getNome(), Aluno.getCpf(),
                                Aluno.getMatricula(), Aluno.getDataNascimento()});
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + ex.getMessage());
                }
            }
        });

        JScrollPane scroll = new JScrollPane(tableAluno);
        tablePane.add(scroll, BorderLayout.CENTER);
        panel.add(tablePane, BorderLayout.CENTER);
        panel.add(atualizar, BorderLayout.SOUTH);

        tableAluno.setFont(font);
        atualizar.setForeground(Color.WHITE);
        atualizar.setBackground(backgroundColor);

        int borderRadius = 15; // Ajuste conforme necessário
        atualizar.setBorder(BorderFactory.createEmptyBorder(10, borderRadius, 10, borderRadius));
        atualizar.setBackground(backgroundColor);

        int formWidth = 900; // ajuste conforme necessário
        int formHeight = 700; // ajuste conforme necessário
        panel.setPreferredSize(new Dimension(formWidth, formHeight));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), // margens internas
                BorderFactory.createLineBorder(Color.BLACK) // borda preta
        ));

        // Adiciona o JScrollPane ao JPanel
        setBackground(backgroundColor);
        // Adiciona o JScrollPane ao JPanel
        add(panel, BorderLayout.CENTER);
    }
}
