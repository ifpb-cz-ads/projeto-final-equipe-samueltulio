package view.components.aluno;

import daoSQL.AlunoDao;
import model.Aluno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class DeletarAlunoTela extends JPanel {
    AlunoDao aDao;
    List<Aluno> listAluno;
    String[] colNames = {"Email", "Nome", "CPF", "Matrícula", "Data de Nascimento"};

    public DeletarAlunoTela() throws SQLException, ClassNotFoundException {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(5, 1));

        aDao = new AlunoDao();
        listAluno = aDao.listAluno();

        JLabel matriculaLbl = new JLabel("Informe a matricula do professor");
        JTextField matriculaTxt = new JTextField();
        JButton pesquisar = new JButton("Pesquisar");

        DefaultTableModel tableModel = new DefaultTableModel(colNames, 0);
        JTable tableAluno = new JTable(tableModel);

        pesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int mat = Integer.parseInt(matriculaTxt.getText());
                    Aluno aluno = aDao.searchAluno(mat);
                    tableModel.addRow(new Object[]{aluno.getEmail(), aluno.getNome(), aluno.getCpf(),
                            aluno.getMatricula(), aluno.getDataNascimento()});
                } catch (NumberFormatException ex) {
                    // Tratamento para entrada inválida de matrícula
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton apagarAluno = new JButton("Apagar");

        apagarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int mat = Integer.parseInt(matriculaTxt.getText());
                    if(aDao.deleteAluno(mat)) {
                        JOptionPane.showMessageDialog(null, "Deletado com sucesso.");
                        tableModel.setRowCount(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao deletar.");
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
        form.add(tableAluno);
        form.add(apagarAluno);

        panel.add(form, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
    }

}
